package com.example.librarymanagementsystem.service;


import com.example.librarymanagementsystem.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {
	
	List<Book> findAllBooks();
	
	Book createBook(Book book);
	
	void updateBook(Book book);
	
	void deleteBook(Long id);
	
	Optional<Book> findBookById(Long id);
}
