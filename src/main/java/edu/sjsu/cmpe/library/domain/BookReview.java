package edu.sjsu.cmpe.library.domain;

public class BookReview {

	private long ID; 
	private long Rating;
	private String Comment;
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public long getRating() {
		return Rating;
	}
	public void setRating(long rating) {
		Rating = rating;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	} 

}
