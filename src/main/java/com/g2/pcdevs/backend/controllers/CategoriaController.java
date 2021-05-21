package com.g2.pcdevs.backend.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g2.pcdevs.backend.models.Categoria;
import com.g2.pcdevs.backend.repository.CategoriaRepository;

@CrossOrigin
@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> index(){
		
		List<Categoria> categorias = this.categoriaRepository.findAll();
		
		return ResponseEntity.ok(categorias);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable Long id){
		
		Categoria categoria = this.categoriaRepository.findById(id).get();
		
		return ResponseEntity.ok(categoria);
	}
	
	
	@PostMapping
	public ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria){
		Categoria categoriaCadastrada = this.categoriaRepository.save(categoria);
		return ResponseEntity.ok(categoriaCadastrada);
	}

}

