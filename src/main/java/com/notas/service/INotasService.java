package com.notas.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.notas.model.Notas;



public interface INotasService {
	
	public Iterable<Notas> findAll();
	
	public Page<Notas> findAll(Pageable pageable);
	
	public Optional<Notas> findById(Long id);
	
	public Notas save1(Notas materias);
	
	public void deleteById(Long id);
	
	public int save(Notas notas);

}
