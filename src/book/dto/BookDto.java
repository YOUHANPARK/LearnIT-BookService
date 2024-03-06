package book.dto;

import java.util.Date;

public class BookDto {
	/**
	 * 도서검색 
	 */
	
	public static class SearchBookByTitleInputDto{
		String title;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
		
	}
	public static class SearchBookByTitleOutputDto {
		long bookseq;
		String title;
		String booknum;
		String publisher;
		String author;
		boolean bookposb;
		
		
		public SearchBookByTitleOutputDto() {
			super();
		}
		public SearchBookByTitleOutputDto(long bookseq, String title, String booknum, String publisher, String author,
				boolean bookposb) {
			super();
			this.bookseq = bookseq;
			this.title = title;
			this.booknum = booknum;
			this.publisher = publisher;
			this.author = author;
			this.bookposb = bookposb;
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
		public String getBooknum() {
			return booknum;
		}
		public void setBooknum(String booknum) {
			this.booknum = booknum;
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
		public boolean isBookposb() {
			return bookposb;
		}
		public void setBookposb(boolean bookposb) {
			this.bookposb = bookposb;
		}
		
		
		
		
	}
	
	public static class SearchBookByCategoryInputDto {
		String category;
		
	}
	public static class SearchBookByCategoryOutputDto {
		long bookseq;
		String title;
		int booknum;
		String publisher;
		String author;
		boolean bookposb;
	}
	
	public static class SearchBookBySeqInputDto{
		long bookseq;
	}
	public static class SearchBookBySeqOutputDto{
		long bookseq;
		String title;
		int booknum;
		String publisher;
		String author;
		String intro;
		boolean bookposb;
		int pubyear;
	}
	
	public static class AddFavoriteBookInputDto{
		long userseq;
		long bookseq;
		Date favordate;
	}
	
	
	public static class ViewFavoriteBookInputDto{
		long userseq;
	}
	public static class ViewFavoriteBookOutputDto{
		String title;
		int booknum;
		String publisher;
		String author;
		boolean bookposb;
	}
	
	public static class DeleteFavoriteBookInputDto{
		String title;
		long userseq;
	}
	
	public static class CheckBookAvailabilityBySeqInputDto{
		long bookseq;
		long userseq;
	}
	public static class CheckBookAvailabilityBySeqOutputDto{
		Date returndate;
		int bookposbnum;
	}
	
	public static class RegisterBookUnrequestedInputDto{
		String title;
		int booknum;
		String publisher;
		String intro;
		String author;
		int pubyear;
		boolean bookposb;
		long userseq;
	}
	
	public static class RegisterBookRequestedInputDto{
		String title;
		int booknum;
		String publisher;
		String intro;
		String author;
		int pubyear;
		boolean bookposb;
		long userseq;
	}
	
	public static class UpdateBookBySeqInputDto{
		String title;
		int booknum;
		String publisher;
		String author;
		int pubyear;
		long bookseq;
		long userseq;
	}
	
	public static class DeleteBookInputDto{
		long bookseq;
		long userseq;
	}
	
	public static class RequestBookInputDto{
		String title;
		String publisher;
		String author;
		int pubyear;
		long userseq;
	}
	
	public static class ViewBookRequestsInputDto{
		String title;
		String publisher;
		String author;
		int pubyear;
		long userseq;
	}
	public static class ViewBookRequestsOutputDto{
		Date requestdate;
		int requeststatus;
		String addtitle;
		String addauthor;
	}
	
	public static class ManageBookRequestInputDto{
		String title;
		String publisher;
		String author;
		int pubyear;
		long userseq;
	}
	public static class ManageBookRequestOutputDto{
		Date requestdate;
		int requeststatus;
		String addtitle;
		String addauthor;
		long requestuserseq;
	}
	
	public static class ReturnBookBySeqInputDto{
		long bookseq;
		long userseq;
	}
	public static class ReturnBookBySeqOutputDto{
		Date rentdate;
		Date returndate;
	}
	
	public static class ExtendBookLoanBySeqInputDto{
		long bookseq;
		long userseq;
	}
	public static class ExtendBookLoanBySeqOutputDto{
		Date returndate;
	}
	
	public static class RateBookInputDto{
		int score;
		long bookseq;
		long userseq;
	}
	
	public static class ViewLoanHistoryInputDto{
		long userseq;
	}
	public static class ViewLoanHistoryOutputDto{
		String title;
		int booknum;
		String publisher;
		String author;
		int pubyear;
		Date loandate;
		Date returndate;
	}
	
	public static class RecommendBookInputDto{
		long userseq;
		long ratingseq;
	}
	public static class RecommendBookOutputDto{
		String title;
		int booknum;
		String publisher;
		String author;
		int pubyear;
		boolean bookposb;
	}
}

