package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.example.demo.domain.Book;

public class BookDTO implements Serializable {

	private static final long serialVersionUID = 10L;

	private Integer id;
	
	@NotEmpty(message="Can not be empty")
	@Length(min=1, max=100, message="Min 5 - Max 100")
	private String name;
	
	public BookDTO() {}
	
	public BookDTO(Book book) {
		
		id = book.getId();
		name = book.getName();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
