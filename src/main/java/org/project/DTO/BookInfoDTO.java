package org.project.DTO;


public class BookInfoDTO {
	private Integer rank;
	private String bookName;
	private String author;
	private String publisher;
	private String bookCounts;

	public BookInfoDTO() {
	}
	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getBookCounts() {
		return bookCounts;
	}

	public void setBookCounts(String bookCounts) {
		this.bookCounts = bookCounts;
	}
}
