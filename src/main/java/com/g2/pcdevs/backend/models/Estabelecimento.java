package com.g2.pcdevs.backend.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "estabelecimento")

public class Estabelecimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEstab;
	
	@Column
	private Long foto;
	
	@Column(name = "categoria", nullable = false)
	private String categoria;
	
	@Column(name = "subCat", nullable = false)
	private String subCat;
	
	@Column(name = "reponsavel", nullable = false)
	private Integer responsavel;
	
	@Column(name = "status", nullable = false)
	private boolean status;
	
	@Column(name = "razaoSocial", nullable = false)
	private String razaoSocial;
	
	@Column(name = "cnpj", nullable = false )
	private String cnpj;
	
	@Column(name = "nomeFantasia", nullable = false)
	private String nomeFantasia;
	
	private String email;
	private String site;
	private String telFixo;
	private String telCel;
	
	@Column(name = "descrNegocio", nullable = false)
	private String descrNegocio;
	
	@Column(name = "cep", nullable = false)
	private String cep;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String mapa;
	private String referencia;
	
	@Column(name = "horarioFunc", nullable = false)
	private String horarioFunc;
	private String fotoLogomarca;
	@Column(name = "dataCriacao", nullable = false)
	private LocalDateTime	dataCriacao;
	
		
}
