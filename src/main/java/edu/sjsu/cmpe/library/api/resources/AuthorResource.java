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
import edu.sjsu.cmpe.library.dto.BookReviewDto;
import edu.sjsu.cmpe.library.dto.LinkDto;
import edu.sjsu.cmpe.library.repository.BookRepository;

@Path("/v1/books/{isbn}/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {
	/*
	@GET
    public Response viewallauthor(@PathParam("isbn") LongParam isbn){
		Book book = BookRepository.getBookByISBN(isbn.get());
    	String location="/books/1/reviews/" + bookReview.getID();
    	reviewResponse.addLink(new LinkDto("view-review", location, "GET"));
    	return Response.status(201).entity(bookReview).build();
    }*/
}
