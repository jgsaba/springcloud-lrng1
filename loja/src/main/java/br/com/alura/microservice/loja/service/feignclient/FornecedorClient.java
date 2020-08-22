package br.com.alura.microservice.loja.service.feignclient;

import br.com.alura.microservice.loja.dto.InfoPedidoDTO;
import br.com.alura.microservice.loja.dto.ItemDaCompraDTO;
import br.com.alura.microservice.loja.service.InfoFornecedorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @GetMapping("/info/{estado}")
    InfoFornecedorDTO getFornecedorInfo(@PathVariable String estado);

    @PostMapping("/pedido")
    InfoPedidoDTO realizaPedido(@RequestBody List<ItemDaCompraDTO> itensDaCompra);
}
