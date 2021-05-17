package com.g2.pcdevs.backend.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.g2.pcdevs.backend.dto.input.UserInputDTO;
import com.g2.pcdevs.backend.dto.output.UserOutputDTO;
import com.g2.pcdevs.backend.models.User;
//import com.g2.pcdevs.backend.repository.UserRepository;
import com.g2.pcdevs.backend.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public List<UserOutputDTO> buscarTodos() {	
		return service.buscarTodos();		
	}
	
	@GetMapping("/{id_user}")
	public ResponseEntity<UserOutputDTO> buscarPorId(@PathVariable Long id_user) {				
		
		UserOutputDTO userDTO = service.buscarId(id_user);
		
		if(!userDTO.equals(null)) {
			return ResponseEntity.ok( userDTO );
		}
		
		return ResponseEntity.notFound().build();
	}
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserOutputDTO salvar(@RequestBody @Valid UserInputDTO userInput) {
		
		return service.salvar(userInput);
	
	}

	@PutMapping("/{id_user}")
	public ResponseEntity<UserOutputDTO> atualizar(@RequestBody UserInputDTO userInput, @PathVariable Long id_user) {

		Optional<User> cli = service.buscarPorId( id_user );
		
		if( cli.isPresent() ) {
			return ResponseEntity.ok( service.atualizar( cli.get(), userInput ) );
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id_user}")
	public ResponseEntity<User> excluir(@PathVariable Long id_user) {
		
		Optional<User> cli = service.buscarPorId( id_user );
		
		if(cli.isPresent()) {
			service.excluir(id_user);
			return 	ResponseEntity.noContent().build();		
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/buscar-por-nome")
	public List<User> buscarPorNome(@RequestParam String nome){
		return service.buscarPorNome(nome);
	}
}
