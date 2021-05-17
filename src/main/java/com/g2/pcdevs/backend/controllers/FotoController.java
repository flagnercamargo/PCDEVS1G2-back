package com.g2.pcdevs.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.g2.pcdevs.backend.models.Foto;
import com.g2.pcdevs.backend.repository.FotoRepository;

@CrossOrigin
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
	
	@GetMapping("/{id}")
	public ResponseEntity<Foto> getById(@PathVariable Long id){
		
		Foto foto = this.fotoRepository.findById(id).get();
		
		return ResponseEntity.ok(foto);
	}
	
	@PostMapping
	public ResponseEntity<Foto> salvar(@RequestBody Foto foto){
		Foto fotoCadastrada = this.fotoRepository.save(foto);
		return ResponseEntity.ok(fotoCadastrada);
	}

	@PutMapping
	public ResponseEntity<Foto> atualizar(@RequestBody Foto foto) {
		
		Optional<Foto> atualizarFoto = service.buscarPorId(foto.getId() );
		
		if( atualizarFoto.isPresent() ) {
			BeanUtils.copyProperties(Foto, atualizarFoto.get(), "id"); 
		}
		
	@DeleteMapping("/{id}")
	public ResponseEntity<Foto> excluir(@PathVariable Long id) {
			
		Optional<Foto> foto =  service.buscarPorId( id );
			
		if(foto.isPresent()) {
			service.excluir(id);
			return 	ResponseEntity.noContent().build();		
		}
		
		return ResponseEntity.notFound().build();
			
	}	
	
	}
