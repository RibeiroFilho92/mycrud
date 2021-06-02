package com.example.demo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.Autor;
import com.example.demo.domain.services.AutorService;
import com.example.demo.dto.AutorDTO;

@RestController @RequestMapping(value="/autors") @CrossOrigin(origins="http://localhost:3000")
public class AutorResource {
	
	@Autowired
	private AutorService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Autor> findById(@PathVariable Integer id) {
		
		Autor autor = service.findById(id);
		
		return ResponseEntity.ok().body(autor);
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AutorDTO autordto) {
		
		Autor autor = service.toDTO(autordto);
		autor = service.insert(autor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(autor.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody AutorDTO autordto) {
		
		Autor autor = service.toDTO(autordto);
		autor.setId(id);
		autor = service.update(autor);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
		
		service.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<AutorDTO>> findAll() {
		
		List<Autor> autorsList = service.findAll();
		List<AutorDTO> autorsListDTO = autorsList.stream().map(autor -> new AutorDTO(autor)).collect(Collectors.toList());
		
		
		return ResponseEntity.ok().body(autorsListDTO);
		
	}
	
	//Não implementado no front**
	@RequestMapping(value="/pages", method=RequestMethod.GET)
	public ResponseEntity<Page<AutorDTO>> findPage(@RequestParam(value="page", defaultValue="0") Integer page, 
												   @RequestParam(value="linesPerPage", defaultValue="24")Integer linesPerPage, 
												   @RequestParam(value="orderBy", defaultValue="name")String orderBy, 
												   @RequestParam(value="direction", defaultValue="ASC")String direction) {
		
		Page<Autor> autorsList = service.findPage(page, linesPerPage, orderBy, direction);
		Page<AutorDTO> autorsListDTO = autorsList.map(autor -> new AutorDTO(autor));
		
		
		return ResponseEntity.ok().body(autorsListDTO);
		
	}
}
