package com.br.hateoas;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.br.hateoas.model.entities.Produto;
import com.br.hateoas.repositories.ProdutoRepository;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	ProdutoRepository produtoRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Produto p0 = new Produto(null, "Notebook", 3447.99);
		Produto p1 = new Produto(null, "Monitor 20 Polegadas", 999.99);
		Produto p2 = new Produto(null, "Tablet", 1599.99);
		Produto p3 = new Produto(null, "Teclado", 29.99);
		Produto p4 = new Produto(null, "Mouse", 19.99);
		Produto p5 = new Produto(null, "Impressora", 289.99);
		Produto p6 = new Produto(null, "Placa de Video", 799.99);
		Produto p7 = new Produto(null, "Fonte", 499.99);
		Produto p8 = new Produto(null, "Memoria", 399.99);
		Produto p9 = new Produto(null, "Caixa de Som", 59.99);
		
		produtoRepository.saveAll(Arrays.asList(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9));
		
	}

}
