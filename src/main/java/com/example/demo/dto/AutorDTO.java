package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.example.demo.domain.Autor;

public class AutorDTO {

	private Integer id;
	
	@NotEmpty(message="Can not be empty")
	@Length(min=5, max=50, message="Min 5 - Max 50")
	private String name;
	
	public AutorDTO() {}
	
	public AutorDTO(Autor autor) {
		
		id = autor.getId();
		name = autor.getName();
		
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
