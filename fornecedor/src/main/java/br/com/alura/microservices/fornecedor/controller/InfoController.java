package br.com.alura.microservices.fornecedor.controller;

import br.com.alura.microservices.fornecedor.model.InfoFornecedor;
import br.com.alura.microservices.fornecedor.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @GetMapping("/{estadoUF}")
    public InfoFornecedor getInfoPorEstado(@PathVariable String estadoUF) {
        return infoService.getInfoPorEstado(estadoUF);
    }
}
