package edu.sjsu.cmpe.library.repository;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import edu.sjsu.cmpe.library.api.resources.BookResource;
import edu.sjsu.cmpe.library.domain.Author;
import edu.sjsu.cmpe.library.domain.Book;
import edu.sjsu.cmpe.library.domain.BookReview;

public class BookRepository implements BookRepositoryInterface {
	List <BookReview> review=new ArrayList<BookReview>();
	List <Author> author=new ArrayList<Author>();
    /** In-memory map to store books. (Key, Value) -> (ISBN, Book) */
    private final ConcurrentHashMap<Long, Book> bookInMemoryMap;

    /** Never access this key directly; instead use generateISBNKey() */
    private long isbnKey;
    private long authorKey;
   private long reviewKey=0;

    public BookRepository(ConcurrentHashMap<Long, Book> bookMap) {
	checkNotNull(bookMap, "bookMap must not be null for BookRepository");
	bookInMemoryMap = bookMap;
	isbnKey = 0;
	authorKey = 0;
	reviewKey=0;
    }
  

    /**
     * This should be called if and only if you are adding new books to the
     * repository.
     * 
     * @return a new incremental ISBN number
     */
   
    /**
     * This should be called if and only if you are adding new books to the
     * repository.
     * 
     * @return a new incremental ISBN number
     */
    private final Long generateISBNKey() {
	// increment existing isbnKey and return the new value
	return Long.valueOf(++isbnKey);
    }
    
    private final Long generateauthorKey() {
    	// increment existing isbnKey and return the new value
    	return Long.valueOf(++authorKey);
        }
    private final Long generatereviewKey() {
    	// increment existing isbnKey and return the new value
    	return Long.valueOf(++reviewKey);
        }

    /**
     * This will auto-generate unique ISBN for new books.
     */
    @Override
    public Book saveBook(Book newBook) {
	checkNotNull(newBook, "newBook instance must not be null");
	// Generate new ISBN
	Long isbn = generateISBNKey();
	newBook.setIsbn(isbn);
	author=newBook.getAuthors();
	for(Author a: author){
		a.setId(generateauthorKey()); 
	}
	//newBook.setAuthors(author);
	
	bookInMemoryMap.put(isbn, newBook);
	return newBook;
    }

    /**
     * @see edu.sjsu.cmpe.library.repository.BookRepositoryInterface#getBookByISBN(java.lang.Long)
     */
    @Override
    public Book getBookByISBN(Long isbn) {
	checkArgument(isbn > 0,
		"ISBN was %s but expected greater than zero value", isbn);
	return bookInMemoryMap.get(isbn);
    }
    @Override
    public void delBookByISBN(Long isbn){
    	checkArgument(isbn > 0,
    			"ISBN was %s but expected greater than zero value", isbn);
    	bookInMemoryMap.remove(isbn);
    		//return bookInMemoryMap.get(isbn) ;
    	}
    @Override
    public Book updateStatusByISBN(Long isbn, String newstatus){
    	Book book = getBookByISBN(isbn);
    	book.setStatus(newstatus);
    	return book;
    }


	@Override
	public Book createreview(Book book, BookReview bookreview) {
			Long key=generatereviewKey();
			bookreview.setID(key);
			
			review.add(bookreview);
			book.setReview(review);
			saveBook(book);
			return book;	
	}

	
    }


