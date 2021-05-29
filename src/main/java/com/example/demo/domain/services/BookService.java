package com.example.demo.domain.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Book;
import com.example.demo.exceptions.ObjectNotFoundException;
import com.example.demo.repositeries.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	public Book findById(Integer id) {
		
		Optional<Book> autor = repository.findById(id);
		
		return autor.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
		
	}

}
