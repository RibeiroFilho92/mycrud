package com.example.demo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.Book;
import com.example.demo.domain.services.BookService;
import com.example.demo.dto.BookDTO;

@RestController @RequestMapping(value="/books")
public class BookResource {
	
	@Autowired
	private BookService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Book> findById(@PathVariable Integer id) {
		
		Book book = service.findById(id);
		
		return ResponseEntity.ok().body(book);
		
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody BookDTO bookdto) {
		
		Book book = service.toDTO(bookdto);
		book = service.insert(book);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(book.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody BookDTO bookdto, @PathVariable Integer id) {
		
		Book book = service.toDTO(bookdto);
		book.setId(id);
		book = service.update(book);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
		
		service.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<BookDTO>> findAll() {
		
		List<Book> bookssList = service.findAll();
		List<BookDTO> booksListDTO = bookssList.stream().map(book -> new BookDTO(book)).collect(Collectors.toList());
		
		
		return ResponseEntity.ok().body(booksListDTO);
		
	}
	
	@RequestMapping(value="/pages", method=RequestMethod.GET)
	public ResponseEntity<Page<BookDTO>> findPage(@RequestParam(value="page", defaultValue="0") Integer page, 
												   @RequestParam(value="linesPerPage", defaultValue="24")Integer linesPerPage, 
												   @RequestParam(value="orderBy", defaultValue="name")String orderBy, 
												   @RequestParam(value="direction", defaultValue="ASC")String direction) {
		
		Page<Book> booksList = service.findPage(page, linesPerPage, orderBy, direction);
		Page<BookDTO> booksListDTO = booksList.map(book -> new BookDTO(book));
		
		
		return ResponseEntity.ok().body(booksListDTO);
		
	}
}
