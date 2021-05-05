package com.g2.pcdevs.backend.serivce;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.g2.pcdevs.backend.models.Estabelecimento;

@Service
public class EstabelecimentoService {

		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
		
		@Autowired
		private PasswordEncoder passwordEncoder;
		
		@Transactional
		public Startup salvar(Estabelecimento estabelecimento) {
			String senha = estabelecimento.getSenha();
			senha = passwordEncoder().encode(senha);
			estabelecimento.setSenha(senha);
			
			return null;
			
		}
}
