package com.g2.pcdevs.backend.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "servico")

public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idServico;
	
	@Column(name = "nomeServico", nullable = false)
	private String nomeServico;
	
	@Column(name = "tipoServico", nullable = false)
	private String tipoServico;
	
	@Column(name = "iconServico", nullable = false)
	private String iconServico;
	
	@Column(name = "dataCriacao", nullable = false)
	private LocalDateTime dataCriacao;
	
	@ManyToOne
	@JoinColumn(name = "idSubCat", nullable = false)
	private Categoria subcat;
	
	//@ManyToMany(mappedBy = "servicos")
	//private List<SubCategoria> subCats;
    // private Set<Categoria> categorias = new HashSet<>();
}
