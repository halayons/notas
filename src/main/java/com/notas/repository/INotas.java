package com.notas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notas.model.Notas;

@Repository
public interface INotas extends JpaRepository<Notas, Long>{
	

}
