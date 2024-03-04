package book.dto;

import java.util.Date;

public class BookDto {
	
	public static class SearchBookByTitleInputDto{
		String title;
		
	}
	public static class SearchBookByTitleOutputDto {
		long bookseq;
		String title;
		int booknum;
		String publisher;
		String author;
		boolean bookposb;
		
		
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

