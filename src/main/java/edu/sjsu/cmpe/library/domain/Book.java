package edu.sjsu.cmpe.library.domain;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Book {
    private long isbn;
    private String title;
    @JsonProperty("publication-date")
    public String publicationdate;
    public String language;
    @JsonProperty("num-pages")
    public int numpages;
    public String status="available";

    /**
     * @return the isbn
     */
    public long getIsbn() {
	return isbn;
    }

    /**
     * @param isbn
     *            the isbn to set
     */
    public void setIsbn(long isbn) {
	this.isbn = isbn;
    }
    /**
     * @return the language
     */
    public String getLanguage() {
	return language;
	
    }

    /**
     * @param language
     *  			the language to set
     */
    public void setLanguage(String language) {
    	this.language=language;
    }
    
    /**
     * @return the pages
     */
    public int getPages() {
	return numpages;
	
    }

    /**
     * @param pages
     *            the pages to set
     */
    public void setPages(int numpages) {
	this.numpages=numpages;
    }

    /**
 

    /**
     * @return the title
     */
    public String getTitle() {
	return title;
    }
    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
	this.title = title;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(String status) {
	this.status = status;
    }
    
    /**
     * @return the status
     */
    public String getStatus() {
	return status;
    }

   
}
