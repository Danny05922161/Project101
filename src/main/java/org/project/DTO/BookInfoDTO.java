package org.project.DTO;


public class BookInfoDTO {
	private int Rank;
	private String BookName;
	private String Author;
	private String Publisher; 
	private String BookCounts;

	public BookInfoDTO() {
		
	}
	public BookInfoDTO (int Rank, String BookName, String Author, String Publisher, int BookCounts) {
		this.Rank="排名";
		this.BookName="書名";
		this.Author="作者";
		this.Publisher="出版社";
		this.BookCounts="借閱次數";
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
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	public String getBookCounts() {
		return bookCounts;
	}

	public void setBookCounts(String bookCounts) {
		this.bookCounts = bookCounts;
	}
}
