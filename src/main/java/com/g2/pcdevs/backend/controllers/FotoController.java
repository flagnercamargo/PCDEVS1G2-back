package com.g2.pcdevs.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g2.pcdevs.backend.models.Foto;
import com.g2.pcdevs.backend.repository.FotoRepository;

@RestController
@RequestMapping("/fotos")
public class FotoController {
	
	@Autowired
	private FotoRepository fotoRepository;
	
	@GetMapping
	public ResponseEntity<List<Foto>> index(){
		
		List<Foto> fotos = this.fotoRepository.findAll();
		
		return ResponseEntity.ok(fotos);
	}

}
