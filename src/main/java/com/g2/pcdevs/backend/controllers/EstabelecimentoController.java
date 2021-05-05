package com.g2.pcdevs.backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g2.pcdevs.backend.models.*;
import com.g2.pcdevs.backend.repository.*;

@RestController
@RequestMapping("/Estabelecimento")
public class EstabelecimentoController {
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	@GetMapping
	public List<Estabelecimento> lista() {
		List<Estabelecimento> estabelecimento = this.estabelecimentoRepository.findAll();
		return estabelecimento;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estabelecimento> buscaPorId(@PathVariable Long id) {
		Estabelecimento estabelecimento = this.estabelecimentoRepository.getOne(id);
		return ResponseEntity.ok(estabelecimento);
	}
	
	@GetMapping("/teste/{nome}") // endpoint
	public String teste(@PathVariable String nome) {
		return "Olá " + nome;
	}
	
}