package com.g2.pcdevs.backend.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "sub_cat")

public class SubCategoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_subcat;
	
	@Column(name = "nome_sub_cat", nullable = false)
	private String nome_subcat;
	
	private LocalDateTime data_criacao;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria", nullable = false)
	private Categoria categoria;
		
	@OneToMany (mappedBy = "subcat")
	private List<Estabelecimento> estabelecimentos;
	
	@ManyToMany
	@JoinTable(
	  name = "Servicos_subcat", 
	  joinColumns = @JoinColumn(name = "id_subcat"), 
	  inverseJoinColumns = @JoinColumn(name = "id_servico"))
	List<Servico> servicos;
}
