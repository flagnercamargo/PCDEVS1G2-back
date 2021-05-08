package com.g2.pcdevs.backend.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "estabelecimento")

public class Estabelecimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEstab;
	
	@Column(name = "categoria", nullable = false)
	private String categoria;
	
	@Column(name = "subCat", nullable = false)
	private String subCat;
	
	@Column(name = "responsavel", nullable = false)
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
	
	@OneToMany (mappedBy = "estabelecimento")
	private List<Foto> fotos;
	
	@ManyToOne
	@JoinColumn(name = "idUser", nullable = false)
	private User user;
		
	@ManyToOne
	@JoinColumn(name = "idSubCat", nullable = false)
	private SubCategoria subcat;
}
