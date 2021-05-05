package com.g2.pcdevs.backend.repository;

import com.g2.pcdevs.backend.models.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	@Query("from Categoria where idCategoria like :idCategoria%")
	List<Categoria> findByNome(String idCategoria);
	
	@Query("from Categoria order by id DESC")
	List<Categoria> findAll();

    @Query("from SubCat where idSubCat like :idSubCat%")
	List<SubCat> findByNome(String idSubCat);
	
	@Query("from SubCat order by id DESC")
	List<SubCat> findAll();
	
}