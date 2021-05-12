package com.g2.pcdevs.backend.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
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
@Table(name = "estabelecimento")

public class Estabelecimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEstab;
	
	@ManyToOne
	@JoinColumn(name = "responsavel", nullable = false)
	private User responsavel;
	
	@Column(name = "status", nullable = false)
	private boolean status;
	
	@Column(name = "razao_social", nullable = false)
	private String razao_social;
	
	@Column(name = "cnpj", nullable = false )
	private String cnpj;
	
	@Column(name = "nome_fantasia", nullable = false)
	private String nome_fantasia;
	
	private String email;
	private String site;
	private String tel_fixo;
	private String tel_cel;
	
	@Column(name = "descr_negocio", nullable = false)
	private String descr_negocio;
	
	@Embedded
	private Endereco endereco;
	
	@Column(name = "horario_func", nullable = false)
	private String horario_func;
	
	private String foto_logomarca;
	
	private LocalDateTime data_criacao;
	
	@OneToMany (mappedBy = "estabelecimento")
	private List<Foto> fotos;
	
	@JsonIgnoreProperties("estabelecimentos")
	@ManyToOne
	@JoinColumn(name = "id_subcat", nullable = false)
	private SubCategoria subcat;
	
	@ManyToMany
	@JoinTable(
	  name = "estabelecimento_servico", 
	  joinColumns = @JoinColumn(name = "id_estabelecimento"), 
	  inverseJoinColumns = @JoinColumn(name = "id_servico"))
	List<Servico> servicos;
}
