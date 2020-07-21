package br.com.alura.microservice.loja.dto;

import lombok.Data;

import java.util.List;

@Data
public class CompraDto {
    private List<ItemDaCompraDTO> itens;
    private EnderecoDTO endereco;
}
