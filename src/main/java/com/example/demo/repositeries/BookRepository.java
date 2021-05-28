package com.example.demo.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	
}
