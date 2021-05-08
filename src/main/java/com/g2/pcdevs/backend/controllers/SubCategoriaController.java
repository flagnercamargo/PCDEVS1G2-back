package com.g2.pcdevs.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}	
