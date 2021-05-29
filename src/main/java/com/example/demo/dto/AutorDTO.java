package com.example.demo.dto;

import com.example.demo.domain.Autor;

public class AutorDTO {

	private Integer id;
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
