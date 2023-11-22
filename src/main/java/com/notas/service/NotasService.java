package com.notas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.notas.model.Notas;
import com.notas.repository.INotas;

@Service
public class NotasService implements INotasService{
	
	@Autowired
	private INotas notasRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Notas> findAll() {
		return notasRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Notas> findAll(Pageable pageable) {
		return notasRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public Optional<Notas> findById(Long id) {
		return notasRepository.findById(id);
	}

	@Override
	@Transactional
	public Notas save1(Notas notas) {
		return notasRepository.save(notas);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		notasRepository.deleteById(id);
	}

	@Override
	@Transactional
	public int save(Notas notas) {
		int res=0;
		Notas n=notasRepository.save(notas);
		if(!n.equals(null)) {
			res=1;
		}			
		return res;
	}
}


