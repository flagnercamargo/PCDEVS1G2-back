package com.g2.pcdevs.backend.dto.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInputDTO {

	@NotBlank
	@NotNull
	private String nome;
	private String email;
	private String senha;
	private String tel_cel;
}
