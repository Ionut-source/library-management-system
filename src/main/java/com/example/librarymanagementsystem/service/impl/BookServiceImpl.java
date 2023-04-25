package com.example.librarymanagementsystem.service.impl;

import com.example.librarymanagementsystem.entity.Book;
import com.example.librarymanagementsystem.repository.BookRepository;
import com.example.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}
	
	@Override
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	
	@Override
	public void updateBook(Book book) {
		bookRepository.save(book);
	}
	
	@Override
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	
	@Override
	public Optional<Book> findBookById(Long id) {
		return bookRepository.findById(id);
	}
}
