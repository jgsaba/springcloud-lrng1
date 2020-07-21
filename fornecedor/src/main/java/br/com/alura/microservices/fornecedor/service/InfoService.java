package br.com.alura.microservices.fornecedor.service;

import br.com.alura.microservices.fornecedor.model.InfoFornecedor;
import br.com.alura.microservices.fornecedor.repository.InfoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    @Autowired
    private InfoRepositoy infoRepositoy;

    public InfoFornecedor getInfoPorEstado(String estadoUf){
        return infoRepositoy.findByEstado(estadoUf);
    }
}
