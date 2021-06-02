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
		
		Book b7 = new Book(null, "The Hobbit", a3);
		Book b8 = new Book(null, "The Lord of the Rings", a3);
		Book b9 = new Book(null, "The Silmarillion", a3);
		
		Book b10 = new Book(null, "Mistborn: The Final Empire", a4);
		Book b11 = new Book(null, "Mistborn: The Well of Ascension", a4);
		Book b12 = new Book(null, "Mistborn: The Hero of Ages", a4);
		
		Book b13 = new Book(null, "The Adventures of Sherlock Holmes", a5);
		Book b14 = new Book(null, "The Memoirs of Sherlock Holmes", a5);
		Book b15 = new Book(null, "The Return of Sherlock Holmes", a5);
		
		Book b16 = new Book(null, "The Da Vinci Code", a6);
		Book b17 = new Book(null, "Angels & Demons", a6);
		Book b18 = new Book(null, "The Lost Symbol", a6);
		
		Book b19 = new Book(null, "JavaScript and JQuery", a7);
		Book b20 = new Book(null, "Accessible XHTML and CSS Web Sites", a7);
		Book b21 = new Book(null, "HTML & CSS", a7);
		
		a1.getBooks().addAll(Arrays.asList(b1, b2, b3));
		a2.getBooks().addAll(Arrays.asList(b4, b5, b6));
		a3.getBooks().addAll(Arrays.asList(b7, b8, b9));
		a4.getBooks().addAll(Arrays.asList(b10, b11, b12));
		a5.getBooks().addAll(Arrays.asList(b13, b14, b15));
		a6.getBooks().addAll(Arrays.asList(b16, b17, b18));
		a7.getBooks().addAll(Arrays.asList(b19, b20, b21));
		
		autorRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5, a6, a7));
		bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21));
		
	}
}
