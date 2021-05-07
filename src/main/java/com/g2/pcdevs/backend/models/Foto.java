package com.g2.pcdevs.backend.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "foto")

public class Foto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFoto;
	
	@Column(name = "urlFoto", nullable = false)
	private String urlFoto;
	
	@Column(name = "descrFoto", nullable = false)
	private LocalDateTime	descrFoto;

	@ManyToOne
	@JoinColumn(name = "idEstab", nullable = false)
	private Estabelecimento estabelecimento;
}
