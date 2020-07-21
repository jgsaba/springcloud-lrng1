package br.com.alura.microservice.loja.service;

import br.com.alura.microservice.loja.dto.CompraDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    @Autowired
    private RestTemplate restTemplate;

    public void realizaCompra(CompraDto compraDto) {

        // ResponseEntity will be deprecated soon. Always look forward to use WebClient instead
        ResponseEntity<InfoFornecedorDTO> exchange = restTemplate.exchange("http://fornecedor/info/" + compraDto.getEndereco().getEstado(),
                HttpMethod.GET, null, InfoFornecedorDTO.class);

        System.out.println(exchange.getBody().getEndereco());
    }
}
