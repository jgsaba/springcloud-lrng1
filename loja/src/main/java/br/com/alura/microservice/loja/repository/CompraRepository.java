package br.com.alura.microservice.loja.repository;

import br.com.alura.microservice.loja.model.Compra;
import org.springframework.data.repository.CrudRepository;

public interface CompraRepository extends CrudRepository<Compra, Long> {
}
