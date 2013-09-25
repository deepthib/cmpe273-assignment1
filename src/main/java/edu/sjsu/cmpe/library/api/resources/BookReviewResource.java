package edu.sjsu.cmpe.library.api.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.yammer.dropwizard.jersey.params.LongParam;
import com.yammer.metrics.annotation.Timed;

import edu.sjsu.cmpe.library.domain.Book;
import edu.sjsu.cmpe.library.domain.BookReview;
import edu.sjsu.cmpe.library.dto.BookDto;
import edu.sjsu.cmpe.library.dto.BookReviewDto;
import edu.sjsu.cmpe.library.dto.LinkDto;
import edu.sjsu.cmpe.library.repository.BookRepositoryInterface;
import edu.sjsu.cmpe.library.repository.BookReviewRepositoryInterface;

@Path("/v1/books/{isbn}/reviews")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookReviewResource {
	
	private final BookReviewRepositoryInterface bookReviewRepository;

	/**
     * BookResource constructor
     * 
     * @param bookRepository
     *            a BookRepository instance
     */
    public BookReviewResource(BookReviewRepositoryInterface bookReviewRepository) {
	this.bookReviewRepository = bookReviewRepository;
    }

     

	@POST
     @Timed(name="create-bookreview")
    public Response createreview(@PathParam("isbn") LongParam isbn, BookReview request){
    	 BookReview saveReview = bookReviewRepository.saveReview(request);
    	 BookReviewDto bookResponse = new BookReviewDto(saveReview);
    	 String location = "/books/" + saveReview.getID();
    		bookResponse.addLink(new LinkDto("view-book", location, "GET"));
    		bookResponse.addLink(new LinkDto("update-book", location, "PUT"));
    		bookResponse.addLink(new LinkDto("delete-book", location, "DELETE"));
    		bookResponse.addLink(new LinkDto("create-review", location, "POST"));
    		return Response.status(201).entity(bookResponse).build();
     }
    @GET
    @Path("/{id}")
    public Response viewreview(@PathParam("id") LongParam id){
    	BookReview bookReview=bookReviewRepository.getReviewById(id.get());
    	BookReviewDto reviewResponse = new BookReviewDto(bookReview);
    	String location="/books/1/reviews/" + bookReview.getID();
    	reviewResponse.addLink(new LinkDto("view-review", location, "GET"));
    	return Response.status(201).entity(bookReview).build();
    }
    //@GET
   // public Response 
}
