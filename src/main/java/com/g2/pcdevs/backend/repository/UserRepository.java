package com.g2.pcdevs.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.g2.pcdevs.backend.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	@Query("from User where nome like :nome%")
	List<User> findByNome(String nome);
	
	@Query("from User order by id_user DESC")
	List<User> findAll();
}
