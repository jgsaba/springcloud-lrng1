package br.com.alura.microservices.fornecedor.repository;

import br.com.alura.microservices.fornecedor.model.InfoFornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepositoy extends JpaRepository<InfoFornecedor, Long> {

    InfoFornecedor findByEstado(String estado);

}
