package com.example.demo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Autor;

@RestController @RequestMapping(value="/autors")
public class CategoryResource {

	@RequestMapping(method=RequestMethod.GET)
	public List<Autor> test() {
		
		Autor a1 = new Autor(1, "Stephen King");
		Autor a2 = new Autor(2, "George R. R. Martin");
		
		List<Autor> list = new ArrayList<> ();
		list.add(a1);
		list.add(a2);
		
		return list;
		
	}
	
}
