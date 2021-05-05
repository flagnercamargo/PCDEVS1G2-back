package com.g2.pcdevs.backend.serivce;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	@Autowired
	private CategoriaMapper categoriaMapper;
	
	@Transactional
	public CategoriaOutputDTO salvar(CategoriaInputDTO categoriaInput) {
		
		String idCategoria = categoriaInput.getCpf();
		cpf = cpf.replace(".", "").replace("-", "");
		categoriaInput.setCpf(cpf);		
		
		Categoria categoria = categoriaMapper.converterInputDTOParaModel(categoriaInput);
		
		LocalDateTime dataCriacao = LocalDateTime.now();		
		categoria.setDataCriacao( dataCriacao );
		
		String[] nomeCompleto = categoriaInput.getNomeCompleto().split(" ");
		 
		categoria.setNome(nomeCompleto[0]);
		categoria.setSobrenome(nomeCompleto[1]);
		
		categoria = repository.save( categoria );
		
		return categoriaMapper.converterModelParaOutputDTO( categoria );
	}

	public List<CategoriaOutputDTO> buscarTodos() {
		return repository.findAll()
				.stream()
				.map(categoria -> categoriaMapper.converterModelParaOutputDTO(categoria))
				.collect(Collectors.toList());
	}

	public Optional<Categoria> buscarPorId(Long id) {
		return repository.findById(id);
	}
	
	public CategoriaOutputDTO buscarId(Long id) {
		Optional<Categoria> categoria = repository.findById(id);
		
		return categoriaMapper.converterModelParaOutputDTO( categoria.get() );
	}

	@Transactional
	public void excluir(Long id) {
		repository.deleteById(id);		
	}

	public List<Categoria> buscarPorNome(String nome) {	
		return repository.findByNome(nome);
	}

	@Transactional
	public CategoriaOutputDTO atualizar(Categoria categoria, CategoriaInputDTO categoriaInput) {
		
		String cpf = categoriaInput.getCpf();
		cpf = cpf.replace(".", "").replace("-", "");
		categoriaInput.setCpf(cpf);		
		
		Categoria c = categoriaMapper.converterInputDTOParaModel(categoriaInput);
		
		LocalDateTime dataCriacao = LocalDateTime.now();		
		c.setDataCriacao( dataCriacao );		
		String[] nomeCompleto = categoriaInput.getNomeCompleto().split(" ");		 
		c.setNome(nomeCompleto[0]);
		c.setSobrenome(nomeCompleto[1]);
		
		BeanUtils.copyProperties(c, categoria, "id");
		
		categoria = repository.save( categoria );
		
		return categoriaMapper.converterModelParaOutputDTO( categoria );
	}

	
}
