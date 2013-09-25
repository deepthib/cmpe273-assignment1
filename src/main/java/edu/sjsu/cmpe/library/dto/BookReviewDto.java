package edu.sjsu.cmpe.library.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import edu.sjsu.cmpe.library.domain.Book;
import edu.sjsu.cmpe.library.domain.BookReview;

public class BookReviewDto extends LinksDto {
	
	
	    private BookReview bookreview;

	    /**
	     * @param book
	     */
	    public BookReviewDto(BookReview bookreview) {
		super();
		this.bookreview = bookreview;
	    }

	    /**
	     * @return the book
	     */
	    public BookReview getBook() {
		return bookreview;
	    }

	    /**
	     * @param book
	     *            the book to set
	     */
	    public void setBook(BookReview bookreview) {
		this.bookreview = bookreview;
	    }
	}

