package br.com.alura.microservice.loja.dto;

import lombok.Data;

@Data
public class EnderecoDTO {

    private String rua;
    private String numero;
    private String estado;
}
