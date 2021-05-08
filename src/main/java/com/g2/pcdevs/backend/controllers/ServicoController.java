package com.g2.pcdevs.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g2.pcdevs.backend.models.Servico;
import com.g2.pcdevs.backend.repository.ServicoRepository;

@RestController
@RequestMapping("/servicos")
public class ServicoController {
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@GetMapping
	public ResponseEntity<List<Servico>> index(){
		
		List<Servico> servicos = this.servicoRepository.findAll();
		
		return ResponseEntity.ok(servicos);
	}
}	