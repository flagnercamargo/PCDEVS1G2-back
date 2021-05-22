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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "estabelecimento")
public class Estabelecimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEstab;
/*	
	@ManyToOne
	@JoinColumn(name = "responsavel" )
	private User responsavel;
*/	
	@Column(name = "status" )
	private boolean status;
	
	@Column(name = "razao_social")
	private String razaoSocial;
	
	@Column(name = "cnpj"  )
	private String cnpj;
	
	@Column(name = "nome_fantasia" )
	private String nomeFantasia;
	
	private String email;
	private String site;
	private String telefoneFixo;
	private String telefoneCel;
	
	@Column(name = "descr_negocio")
	private String negocio;
	
	@Embedded
	private Endereco endereco;
	
	@Column(name = "horario_func" )
	private String horario;
	
	private String foto_logomarca;
	
	private LocalDateTime data_criacao;
	
	@JsonIgnoreProperties("estabelecimento")
	@OneToMany (mappedBy = "estabelecimento")
	private List<Foto> fotos;
	

	@JsonIgnoreProperties("estabelecimentos")
	@ManyToOne
	@JoinColumn(name = "id_subcat" )
	private SubCategoria subcat;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_user" )
	private User responsavel;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
	  name = "estabelecimento_servico", 
	  joinColumns = @JoinColumn(name = "id_estabelecimento"), 
	  inverseJoinColumns = @JoinColumn(name = "id_servico"))
	List<Servico> servicos;
}
