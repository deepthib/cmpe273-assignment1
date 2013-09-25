package edu.sjsu.cmpe.library.repository;

import com.yammer.dropwizard.jersey.params.LongParam;

import edu.sjsu.cmpe.library.api.resources.BookResource;
import edu.sjsu.cmpe.library.domain.Author;
import edu.sjsu.cmpe.library.domain.Book;
import edu.sjsu.cmpe.library.domain.BookReview;

/**
 * Book repository interface.
 * 
 * What is repository pattern?
 * 
 * @see http://martinfowler.com/eaaCatalog/repository.html
 */
public interface BookRepositoryInterface {
    /**
     * Save a new book in the repository
     * 
     * @param newBook
     *            a book instance to be create in the repository
     * @return a newly created book instance with auto-generated ISBN
     */
    Book saveBook(Book newBook);

    /**
     * Retrieve an existing book by ISBN
     * 
     * @param isbn
     *            a valid ISBN
     * @return a book instance
     */
    Book getBookByISBN(Long isbn);

    
     void delBookByISBN(Long isbn);

	Book updateStatusByISBN(Long isbn, String newstatus);

	Book createreview(Book book, BookReview bookreview);

	      

    
}
