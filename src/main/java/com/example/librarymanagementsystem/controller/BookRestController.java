package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.entity.Book;
import com.example.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/book")
public class BookRestController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books = bookService.findAllBooks();
		return new ResponseEntity<>(books, OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Long> addNewBook(@RequestBody Book book) {
		Book insertedBook = bookService.createBook(book);
		
		if (insertedBook == null) {
			return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(insertedBook.getId(), OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
		return new ResponseEntity<>(OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return new ResponseEntity<>(OK);
	}
	
	@GetMapping("/get{id}")
	public ResponseEntity<Optional<Book>> getBookById(@PathVariable("id") Long id) {
		Optional<Book> bookById = bookService.findBookById(id);
		if (bookById != null && bookById.isPresent()) {
			return new ResponseEntity<>(OK);
		}
		return null;
	}
}
