package com.g2.pcdevs.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g2.pcdevs.backend.models.Estabelecimento;
import com.g2.pcdevs.backend.repository.EstabelecimentoRepository;

@RestController
@RequestMapping("/estabelecimentos")
public class EstabelecimentoController {
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	@GetMapping
	public ResponseEntity<List<Estabelecimento>> index(){
		
		List<Estabelecimento> estabelecimentos = this.estabelecimentoRepository.findAll();
		
		return ResponseEntity.ok(estabelecimentos);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Estabelecimento> getById(@PathVariable Long id){
		
		Estabelecimento estabelecimento = this.estabelecimentoRepository.findById(id).get();
		
		return ResponseEntity.ok(estabelecimento);
	}


}