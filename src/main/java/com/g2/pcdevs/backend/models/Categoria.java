package com.g2.pcdevs.backend.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "categoria")

public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_categoria;
	
	@Column(name = "nome_cat", nullable = false)
	private String nome;
	
	private LocalDateTime data_criacao;
	
	@JsonIgnoreProperties({"categoria"})
	@OneToMany (mappedBy = "categoria")
	private List<SubCategoria> subcats;
	
	
}
