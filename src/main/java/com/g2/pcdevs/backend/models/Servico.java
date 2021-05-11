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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "servico")

public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_servico;
	@Column(name = "nome_servico", nullable = false)
	private String nome_servico;
	
	@Column(name = "tipo_servico", nullable = false)
	private String tipo_servico;
	
	@Column(name = "icon_servico", nullable = false)
	private String icon_servico;
	
	private LocalDateTime data_criacao;
	
	@ManyToOne
	@JoinColumn(name = "id_sub_cat", nullable = false)
	private Categoria subcat;
	
	@ManyToMany(mappedBy = "servicos")
	// @JsonIgnoreProperties("servicos")
	private List<SubCategoria> subcats;
	
}
