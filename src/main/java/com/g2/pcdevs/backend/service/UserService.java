package com.g2.pcdevs.backend.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.g2.pcdevs.backend.dto.input.UserInputDTO;
import com.g2.pcdevs.backend.dto.output.UserOutputDTO;
import com.g2.pcdevs.backend.mapper.UserMapper;
import com.g2.pcdevs.backend.models.User;
import com.g2.pcdevs.backend.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Transactional
	public UserOutputDTO salvar(UserInputDTO userInput) {
		
		String email = userInput.getEmail();
		userInput.setEmail(email);
		
		User user = userMapper.converterInputDTOParaModel(userInput);
		
		LocalDateTime data_criacao = LocalDateTime.now();		
		user.setDataCriacao( data_criacao );
		
		String nome = userInput.getNome();

		user = repository.save( user );
		
		return userMapper.converterModelParaOutputDTO( user );
	}

	public List<UserOutputDTO> buscarTodos() {
		return repository.findAll()
				.stream()
				.map(user -> userMapper.converterModelParaOutputDTO(user))
				.collect(Collectors.toList());
	}

	public Optional<User> buscarPorId(Long id_user) {
		return repository.findById(id_user);
	}
	
	public UserOutputDTO buscarId(Long id_user) {
		Optional<User> user = repository.findById(id_user);
		
		return userMapper.converterModelParaOutputDTO( user.get() );
	}

	@Transactional
	public void excluir(Long id_user) {
		repository.deleteById(id_user);		
	}

	public List<User> buscarPorNome(String nome) {	
		return repository.findByNome(nome);
	}

	@Transactional
	public UserOutputDTO atualizar(User user, UserInputDTO userInput) {
		
		String email = userInput.getEmail();
		userInput.setEmail(email);		
		
		User c = userMapper.converterInputDTOParaModel(userInput);
		
		LocalDateTime dataCriacao = LocalDateTime.now();		
		c.setDataCriacao( dataCriacao );		
		String nome = userInput.getNome();		 
		c.setNome(nome);
		
		BeanUtils.copyProperties(c, user, "id_user");
		
		user = repository.save( user );
		
		return userMapper.converterModelParaOutputDTO( user );
	}
}
