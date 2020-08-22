package br.com.alura.microservice.loja.model;

import br.com.alura.microservice.loja.dto.CompraDto;
import br.com.alura.microservice.loja.dto.InfoPedidoDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long idPedido;
    private Integer tempoDePreparo;
    private String enderecoDeDestino;

    public Compra(CompraDto compraDto, InfoPedidoDTO infoPedido){
        this.idPedido = infoPedido.getId();
        this.tempoDePreparo = infoPedido.getTempoDePreparo();
        this.enderecoDeDestino = compraDto.getEndereco().toString();
    }
}
