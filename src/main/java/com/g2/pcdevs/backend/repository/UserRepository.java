package com.g2.pcdevs.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g2.pcdevs.backend.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}

