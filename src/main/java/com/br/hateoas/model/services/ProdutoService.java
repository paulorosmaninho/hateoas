package com.br.hateoas.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.hateoas.model.entities.Produto;
import com.br.hateoas.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public List<Produto> findAll(){
		return produtoRepository.findAll();
	}

	public Produto findById(Long id){
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.get();
	}
	
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}

}
