package org.project.DTO;


import com.opencsv.bean.CsvBindByName;

public class BookInfoDTO {

	@CsvBindByName(column = "排名")
	private Integer rank;
	@CsvBindByName(column = "書名")
	private String bookName;
	@CsvBindByName(column = "作者")
	private String author;
	@CsvBindByName(column = "出版社")
	private String publisher;
	@CsvBindByName(column = "借閱次數")
	private Integer bookCounts;

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
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

	public Integer getBookCounts() {
		return bookCounts;
	}

	public void setBookCounts(Integer bookCounts) {
		this.bookCounts = bookCounts;
	}
}
