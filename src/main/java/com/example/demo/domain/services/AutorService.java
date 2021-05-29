package com.example.demo.domain.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Autor;
import com.example.demo.exceptions.DataNotFoundException;
import com.example.demo.exceptions.ObjectNotFoundException;
import com.example.demo.repositeries.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository repository;
	
	public Autor findById(Integer id) {
		
		Optional<Autor> autor = repository.findById(id);
		
		return autor.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
		
	}

	public Autor insert(Autor autor) {
		
		autor.setId(null);
		return repository.save(autor);
		
	}
	
	public Autor update(Autor autor) {
		
		findById(autor.getId());
		return repository.save(autor);
		
	}
	
	public void deleteById(Integer id) {
		
		findById(id);
		try {
			
			repository.deleteById(id);
			
		} catch (DataIntegrityViolationException e) {
			
			throw new DataNotFoundException("You are not alowed to remove Authors with Books createds");
			
		}

		
	}
}
