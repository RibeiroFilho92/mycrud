package com.example.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Autor;
import com.example.demo.domain.services.AutorService;

@RestController @RequestMapping(value="/autors")
public class AutorResource {
	
	@Autowired
	private AutorService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		
		Autor autor = service.findById(id);
		
		return ResponseEntity.ok().body(autor);
		
	}
}
