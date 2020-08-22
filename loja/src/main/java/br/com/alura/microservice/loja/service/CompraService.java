package br.com.alura.microservice.loja.service;

import br.com.alura.microservice.loja.dto.CompraDto;
import br.com.alura.microservice.loja.dto.InfoPedidoDTO;
import br.com.alura.microservice.loja.model.Compra;
import br.com.alura.microservice.loja.repository.CompraRepository;
import br.com.alura.microservice.loja.service.feignclient.FornecedorClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class CompraService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private FornecedorClient fornecedorClient;

    @HystrixCommand
    public Compra getById(Long id){
        return compraRepository.findById(id).orElseGet(Compra::new);
    }

    @HystrixCommand(fallbackMethod = "realizaCompraFallBack")
    public Compra realizaCompra(CompraDto compraDto) {

        String estado = compraDto.getEndereco().getEstado();
        log.info("Buscando informações do fornecedor de {}", estado);
        InfoFornecedorDTO infoFornecedor = fornecedorClient.getFornecedorInfo(estado);

        log.info("Realizando um pedido");
        InfoPedidoDTO infoPedidoDTO = fornecedorClient.realizaPedido(compraDto.getItens());
        Compra compraSalva = new Compra(compraDto, infoPedidoDTO);

        return compraRepository.save(compraSalva);
    }

    public Compra realizaCompraFallBack(CompraDto compraDto){
        Compra compraFallBack = new Compra();
        compraFallBack.setEnderecoDeDestino("Endereco default");
        return compraFallBack;
    }
}
