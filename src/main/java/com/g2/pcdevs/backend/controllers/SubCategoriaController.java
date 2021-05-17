package com.g2.pcdevs.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g2.pcdevs.backend.models.Estabelecimento;
import com.g2.pcdevs.backend.models.Foto;
import com.g2.pcdevs.backend.models.SubCategoria;
import com.g2.pcdevs.backend.repository.SubCategoriaRepository;


@RestController
@RequestMapping("/subcategoria")
public class SubCategoriaController {

	@Autowired
	private SubCategoriaRepository subcategoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<SubCategoria>>index(){
		
		List<SubCategoria> subcategorias = this.subcategoriaRepository.findAll();
		
		return ResponseEntity.ok(subcategorias);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SubCategoria> getById(@PathVariable Long id){
		
		SubCategoria subcategoria = this.subcategoriaRepository.findById(id).get();
		
		return ResponseEntity.ok(subcategoria);
	}
	
	@PostMapping
	public ResponseEntity<SubCategoria> salvar(@RequestBody SubCategoria subcategoria){
		SubCategoria subcategoriaCadastrada = this.subcategoriaRepository.save(subcategoria);
		return ResponseEntity.ok(subcategoriaCadastrada);
	}
}	
