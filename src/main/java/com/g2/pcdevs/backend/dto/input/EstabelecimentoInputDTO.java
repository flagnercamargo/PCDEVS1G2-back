package com.g2.pcdevs.backend.dto.input;

import com.sun.istack.NotNull;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstabelecimentoInputDTO {
	
	@NotBlank
	@NotNull
	private String categoria;
	private String subCat;
	private Integer responsavel;
	private boolean status;
	private String razaoSocial;
	private String cnpj;
	private String nomeFantasia;
	private String descrNegocio;
	private String cep;
	private String horarioFunc;
	private LocalDateTime dataCriacao;
	
	private String email;
	private String site;
	private String telFixo;
	private String telCel;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String mapa;
	private String referencia;
	
	
	private String fotoLogomarca;
	
	

}
