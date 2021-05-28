package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Autor;
import com.example.demo.domain.Book;
import com.example.demo.repositeries.AutorRepository;
import com.example.demo.repositeries.BookRepository;

@SpringBootApplication
public class MycrudApplication implements CommandLineRunner{
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(MycrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Autor a1 = new Autor(null, "George R R Martin");
		Autor a2 = new Autor(null, "Stephen King");
		
		Book b1 = new Book(null, "A Game of Thrones", a1);
		Book b2 = new Book(null, "A Clash of Kings", a1);
		Book b3 = new Book(null, "A Storm of Swords", a1);
		
		Book b4 = new Book(null, "The Long Walk", a2);
		Book b5 = new Book(null, "The Running Man", a2);
		Book b6 = new Book(null, "Cycle of the Werewolf", a2);
		
		a1.getBooks().addAll(Arrays.asList(b1, b2, b3));
		a2.getBooks().addAll(Arrays.asList(b4, b5, b6));
		
		autorRepository.saveAll(Arrays.asList(a1, a2));
		bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5, b6));
		
	}

}
