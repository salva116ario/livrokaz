package co.simplon.livrokaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.livrokaz.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

	Iterable<Book> findByBoTitleContainingIgnoreCase(String title);

	Iterable<Book> findByBoEditorContainingIgnoreCase(String editor);

	Iterable<Book> findByBoAuthorContainingIgnoreCase(String author);

}
