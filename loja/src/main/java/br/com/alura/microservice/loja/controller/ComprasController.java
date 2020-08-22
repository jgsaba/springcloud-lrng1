package br.com.alura.microservice.loja.controller;

import br.com.alura.microservice.loja.dto.CompraDto;
import br.com.alura.microservice.loja.model.Compra;
import br.com.alura.microservice.loja.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
@EnableCircuitBreaker
public class ComprasController {

    @Autowired
    CompraService compraService;

    @PostMapping
    public Compra realizaCompra(@RequestBody CompraDto compraDto){
        return compraService.realizaCompra(compraDto);
    }
}
