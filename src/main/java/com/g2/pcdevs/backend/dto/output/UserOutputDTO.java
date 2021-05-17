package com.g2.pcdevs.backend.dto.output;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserOutputDTO {

	private Long id_user;
	private String nome;
	private String email;
	private String senha;
	private String tel_cel;
	private LocalDateTime data_criacao;
}
