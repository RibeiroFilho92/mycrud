package com.example.demo.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
	
	
}
