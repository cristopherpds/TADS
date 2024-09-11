package com.ExemploAula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ExemploAula.model.CategoriaModel;

@Repository
public interface CategoriaRespository extends JpaRepository<CategoriaModel, Integer> {

}
