package com.br.hateoas.controllers;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.hateoas.model.entities.Produto;
import com.br.hateoas.model.services.ProdutoService;

@RestController
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;

	@GetMapping(path = "/produtos")
	public ResponseEntity<List<Produto>> getAllProdutos(){

		List<Produto> produtos = produtoService.findAll();

		if(produtos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			for(Produto produto : produtos) {
				Long id = produto.getId();
				produto.add(linkTo(methodOn(ProdutoController.class).getOneProduto(id)).withSelfRel());
			}
			
			return ResponseEntity.ok().body(produtos);
		}
	}



	@GetMapping(path = "/produtos/{id}")
	public ResponseEntity<Produto> getOneProduto(@PathVariable(value = "id") Long id){

		Produto produto = produtoService.findById(id);

		if(produto == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			
			produto.add(linkTo(methodOn(ProdutoController.class).getAllProdutos()).withSelfRel());
		}

		return ResponseEntity.ok().body(produto);
	}
	
	
	
	@PostMapping(path = "/produtos")
	public ResponseEntity<Produto> inserir(@RequestBody Produto produto){
		produto = produtoService.save(produto);
		return ResponseEntity.ok().body(produto);
	}
	
	
}
