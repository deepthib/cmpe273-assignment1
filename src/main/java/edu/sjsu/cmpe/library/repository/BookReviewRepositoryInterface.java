package edu.sjsu.cmpe.library.repository;

import edu.sjsu.cmpe.library.domain.BookReview;

public interface BookReviewRepositoryInterface {

	BookReview saveReview(BookReview request);
	public BookReview getReviewById(Long id);
}
