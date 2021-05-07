package com.g2.pcdevs.backend.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "categoria")

public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;
	
	@Column(name = "nomeCat", nullable = false)
	private String nomeCat;
	
	@Column(name = "dataCriacao", nullable = false)
	private LocalDateTime dataCriacao;
	
	@OneToMany (mappedBy = "categoria")
	private List<SubCategoria> subCats;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Categoria_Servico", 
        joinColumns = { @JoinColumn(name = "idCategoria") }, 
        inverseJoinColumns = { @JoinColumn(name = "idServico") }
    )
	private List<Servico> servicos;
    // Set<Servico> servicos = new HashSet<>();
	
}
