package book.dto;

import java.util.Date;

public class Book {
	
	long bookseq;
	String title;
	String callnum;
	String publisher;
	String author; 
	String intro;
	int loanposb;
	Date pubyear;
	String category;
	
	
	
	public Book() {
		super();
	}

	public Book(long bookseq, String title, String callnum, String publisher,
			String author, String intro, int loanposb, Date pubyear, String category){
		this.bookseq = bookseq;
		this.title = title;
		this.callnum = callnum;
		this.publisher = publisher;
		this.author = author;
		this.intro = intro;
		this.loanposb = loanposb;
		this.pubyear = pubyear;
		this.category = category;
	}

	public long getBookseq() {
		return bookseq;
	}

	public void setBookseq(long bookseq) {
		this.bookseq = bookseq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCallnum() {
		return callnum;
	}

	public void setCallnum(String callnum) {
		this.callnum = callnum;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public int getLoanposb() {
		return loanposb;
	}

	public void setLoanposb(int loanposb) {
		this.loanposb = loanposb;
	}

	public Date getPubyear() {
		return pubyear;
	}

	public void setPubyear(Date pubyear) {
		this.pubyear = pubyear;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}
