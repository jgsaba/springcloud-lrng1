package br.com.alura.microservices.fornecedor;

import br.com.alura.microservices.fornecedor.model.InfoFornecedor;
import br.com.alura.microservices.fornecedor.repository.InfoRepositoy;
import br.com.alura.microservices.fornecedor.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class FornecedorApplication implements CommandLineRunner {

	@Autowired
	InfoRepositoy infoRepositoy;

	public static void main(String[] args){

		SpringApplication.run(FornecedorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		InfoFornecedor infoFornecedor = new InfoFornecedor();
//		infoFornecedor.setNome("Carne goiana LTDA");
//		infoFornecedor.setEndereco("Rua goiania-av, 2503");
//		infoFornecedor.setEstado("GO");
//
//		infoRepositoy.save(infoFornecedor);
	}
}
