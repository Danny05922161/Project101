package org.project.DTO;


import com.opencsv.bean.CsvBindByName;

public class BookInfoDTO {

	private Integer rank;
	private String bookName;
	private String author;
	private String publisher;
	private Integer bookCounts;

	@Override
	public String toString() {
		return rank + "," +
				QuoteString(bookName) + "," +
				QuoteString(author) + "," +
				QuoteString(publisher) + "," +
				bookCounts + "\n";
	}

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

	private String QuoteString(String tag){
		if(tag.contains(",")){
			return "\""+tag+"\"";
		}
		return tag;
	}
}
