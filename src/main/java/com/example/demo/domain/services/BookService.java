package com.example.demo.domain.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Book;
import com.example.demo.dto.BookDTO;
import com.example.demo.exceptions.DataNotFoundException;
import com.example.demo.exceptions.ObjectNotFoundException;
import com.example.demo.repositeries.AutorRepository;
import com.example.demo.repositeries.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	@Autowired
	private AutorRepository autorRepository;
	
	public Book findById(Integer id) {
		
		Optional<Book> autor = repository.findById(id);
		
		return autor.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
		
	}
	
	@Transactional
	public Book insert(Book book) {
		
		book.setId(null);
		if(book.getAutor() != null) {
			autorRepository.saveAll(Arrays.asList(book.getAutor()));
		}
		book = repository.save(book);
		return book;
		
	}
	
	public Book update(Book book) {
		
		findById(book.getId());
		return repository.save(book);
		
	}
	
	public void deleteById(Integer id) {
		
		findById(id);
		try {
			
			repository.deleteById(id);
			
		} catch (DataIntegrityViolationException e) {
			
			throw new DataNotFoundException("You can not do that");
			
		}

		
	}
	
	public List<Book> findAll() {
		
		return repository.findAll();
		
	}
	
	public Page<Book> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		
		PageRequest pagerequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
		
		return repository.findAll(pagerequest);
		
	}
	
	public Book toDTO(BookDTO book) {
		
		return new Book(book.getId(), book.getName(), null);
		
	}

}
