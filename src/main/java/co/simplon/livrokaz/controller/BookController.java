package co.simplon.livrokaz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.livrokaz.model.Book;
import co.simplon.livrokaz.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/books")
	public ResponseEntity<?> getAllBooks(){
		List<Book> bookList = null;
		try {
			bookList = bookRepository.findAll();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}	
		return ResponseEntity.status(HttpStatus.OK).body(bookList);
	}
	
	@GetMapping("/books/title/{title}")
	public ResponseEntity<?> getBooksByTitle(@PathVariable String title) {
		Iterable<Book> books = null;
		try {
			books = bookRepository.findByBoTitleContainingIgnoreCase(title);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(books);
	}
	
	@GetMapping("/books/editor/{editor}")
	public ResponseEntity<?> getBooksByEditor(@PathVariable String editor) {
		Iterable<Book> books = null;
		try {
			books = bookRepository.findByBoEditorContainingIgnoreCase(editor);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(books);
	}
}
