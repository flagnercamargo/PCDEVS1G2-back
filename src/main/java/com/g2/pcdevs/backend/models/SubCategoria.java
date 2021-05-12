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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "subcategoria")

public class SubCategoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_subcat;
	
	@Column(name = "nome_sub_cat", nullable = false)
	private String nome_subcat;
	
	private LocalDateTime data_criacao;
	
	@JsonIgnoreProperties("subcats")
	@ManyToOne
	@JoinColumn(name = "id_categoria", nullable = false)
	private Categoria categoria;
		
	@JsonIgnoreProperties("subcat")
	@OneToMany (mappedBy = "subcat")
	private List<Estabelecimento> estabelecimentos;
		
}
