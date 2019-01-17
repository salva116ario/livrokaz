package co.simplon.livrokaz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.livrokaz.model.Book;
import co.simplon.livrokaz.repository.BookRepository;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	/**
	 * Retourne la liste de tous les livres
	 * 
	 * @return
	 */
	@GetMapping("/getall")
	public ResponseEntity<?> getAllBooks() {
		List<Book> bookList = null;
		try {
			bookList = bookRepository.findAll();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(bookList);
	}

	/**
	 * Retourne le livre dont l'id est {id}
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getBookById(@PathVariable Integer id) {
		Optional<Book> book = null;
		try {
			book = bookRepository.findById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(book);
	}

	/**
	 * Retourne les livres dont le titre contient {title}
	 * 
	 * @param title
	 * @return
	 */
	@GetMapping("/getbytitle/{title}")
	public ResponseEntity<?> getBooksByTitle(@PathVariable String title) {
		Iterable<Book> books = null;
		try {
			books = bookRepository.findByBoTitleContainingIgnoreCase(title);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(books);
	}

	/**
	 * Retourne les livres dont l'éditeur contient {editor}
	 * 
	 * @param editor
	 * @return
	 */
	@GetMapping("/getbyeditor/{editor}")
	public ResponseEntity<?> getBooksByEditor(@PathVariable String editor) {
		Iterable<Book> books = null;
		try {
			books = bookRepository.findByBoEditorContainingIgnoreCase(editor);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(books);
	}

	/**
	 * Retourne les livres dont l'auteur contient {author}
	 * 
	 * @param author
	 * @return
	 */
	@GetMapping("/getbyauthor/{author}")
	public ResponseEntity<?> getBooksByAuthor(@PathVariable String author) {
		Iterable<Book> books = null;
		try {
			books = bookRepository.findByBoAuthorContainingIgnoreCase(author);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(books);
	}

	/**
	 * Ajoute un livre à la BDD
	 * 
	 * @param book
	 * @return
	 */
	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> addBook(@RequestBody Book book) {
		Book bookToAdd = null;
		try {
			bookToAdd = bookRepository.saveAndFlush(book);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(bookToAdd);
	}

	/**
	 * Modifie un livre de la BDD
	 * 
	 * @param book
	 * @return
	 */
	@PutMapping(value = "/modify", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> modifyBook(@RequestBody Book book) {
		Book bookToModify = null;
		try {
			bookToModify = bookRepository.saveAndFlush(book);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(bookToModify);
	}

	/**
	 * Supprime de la BDD le livre dont l'id = {id}
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable Integer id) {
		try {
			bookRepository.deleteById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
