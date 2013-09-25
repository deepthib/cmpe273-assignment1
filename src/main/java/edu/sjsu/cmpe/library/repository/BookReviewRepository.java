package edu.sjsu.cmpe.library.repository;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.concurrent.ConcurrentHashMap;

import edu.sjsu.cmpe.library.domain.Book;
import edu.sjsu.cmpe.library.domain.BookReview;

public class BookReviewRepository implements BookReviewRepositoryInterface{
	 private final ConcurrentHashMap<Long, BookReview> reviewInMemoryMap;
	
	 private long idKey;	
		
	 private final Long generateIdKey() {
			// increment existing idKey and return the new value
			return Long.valueOf(++idKey);
		    }
	 public BookReviewRepository(ConcurrentHashMap<Long, BookReview> bookreviewMap) {
 	checkNotNull(bookreviewMap, "bookreviewMap must not be null for BookRepository");
 	reviewInMemoryMap = bookreviewMap;
 	idKey = 0;
     }
	@Override
	public BookReview saveReview(BookReview request) {
		checkNotNull(request, "newBook instance must not be null");
		// Generate new Id
		Long idKey = generateIdKey();
		request.setID(idKey);
		// TODO: create and associate other fields such as author

		// Finally, save the new book into the map
		reviewInMemoryMap.putIfAbsent(idKey, request);

		return request;
	    
		
	}
	@Override
	public BookReview getReviewById(Long id) {
		checkArgument(id > 0,
				"ISBN was %s but expected greater than zero value", id);
			return reviewInMemoryMap.get(id);
		
	}
		
	}
