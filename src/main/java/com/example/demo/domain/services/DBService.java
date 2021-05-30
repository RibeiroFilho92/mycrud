package com.example.demo.domain.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Autor;
import com.example.demo.domain.Book;
import com.example.demo.repositeries.AutorRepository;
import com.example.demo.repositeries.BookRepository;

@Service
public class DBService {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private BookRepository bookRepository;

	public void instantiateTestDB() {
		
		Autor a1 = new Autor(null, "George R R Martin");
		Autor a2 = new Autor(null, "Stephen King");
		Autor a3 = new Autor(null, "J R R Tolkien");
		Autor a4 = new Autor(null, "Brandon Sanderson");
		Autor a5 = new Autor(null, "Arthur Conan Doyle");
		Autor a6 = new Autor(null, "Dan Brown");
		Autor a7 = new Autor(null, "Jon Duckett");
		
		Book b1 = new Book(null, "A Game of Thrones", a1);
		Book b2 = new Book(null, "A Clash of Kings", a1);
		Book b3 = new Book(null, "A Storm of Swords", a1);
		
		Book b4 = new Book(null, "The Long Walk", a2);
		Book b5 = new Book(null, "The Running Man", a2);
		Book b6 = new Book(null, "Cycle of the Werewolf", a2);
		
		a1.getBooks().addAll(Arrays.asList(b1, b2, b3));
		a2.getBooks().addAll(Arrays.asList(b4, b5, b6));
		
		autorRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5, a6, a7));
		bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5, b6));
		
	}
}
