package br.com.alura.microservice.loja.controller;

import br.com.alura.microservice.loja.dto.CompraDto;
import br.com.alura.microservice.loja.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class ComprasController {

    @Autowired
    CompraService compraService;

    @PostMapping
    public void realizaCompra(@RequestBody CompraDto compraDto){
        System.out.println(compraDto);
        compraService.realizaCompra(compraDto);
    }
}
