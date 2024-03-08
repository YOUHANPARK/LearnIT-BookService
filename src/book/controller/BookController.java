package book.controller;

import java.util.List;

import book.dto.BookDto.AddFavoriteBookInputDto;
import book.dto.BookDto.CheckBookAvailabilityBySeqInputDto;
import book.dto.BookDto.CheckBookAvailabilityBySeqOutputDto;
import book.dto.BookDto.DeleteFavoriteBookInputDto;
import book.dto.BookDto.RecommendBookInputDto;
import book.dto.BookDto.RecommendBookOutputDto;
import book.dto.BookDto.RegisterBookUnrequestedInputDto;
import book.dto.BookDto.RequestBookInputDto;
import book.dto.BookDto.ReturnBookBySeqInputDto;
import book.dto.BookDto.ReturnBookBySeqOutputDto;
import book.dto.BookDto.SearchBookByCategoryInputDto;
import book.dto.BookDto.SearchBookByCategoryOutputDto;
import book.dto.BookDto.SearchBookBySeqInputDto;
import book.dto.BookDto.SearchBookBySeqOutputDto;
import book.dto.BookDto.SearchBookByTitleInputDto;
import book.dto.BookDto.SearchBookByTitleOutputDto;
import book.dto.BookDto.ViewBookRequestsInputDto;
import book.dto.BookDto.ViewFavoriteBookInputDto;
import book.dto.BookDto.ViewFavoriteBookOutputDto;
import book.dto.BookDto.ViewLoanHistoryInputDto;
import book.dto.BookDto.ViewLoanHistoryOutputDto;
import book.service.BookService;
import config.AppConfig;
import view.EndView;



public class BookController {
    static BookService bookService = AppConfig.getInstance().getBookService();
	
	
	/**
	 * 도서 제목으로 검색
	 */
	public static void SearchBookByTitle(SearchBookByTitleInputDto ip) {
		List<SearchBookByTitleOutputDto> booklist = bookService.SearchBookByTitle(ip);
		EndView.printBookByTitle(booklist);
		
	}
	
	/**
	 * 도서 카테고리로 검색
	 */
	public static void SearchBookByCategory(SearchBookByCategoryInputDto ip) {
		List<SearchBookByCategoryOutputDto> booklist = bookService.SearchBookByCategory(ip);
		EndView.printBookByCategory(booklist);
		
	}
	
	/**
	 * 도서 상세 검색
	 */
	public static void SearchBookBySeq(SearchBookBySeqInputDto ip) {
		SearchBookBySeqOutputDto bookdto = bookService.SearchBookBySeq(ip);
		EndView.printBookBySeq(bookdto);
		
	}
	
	/**
	 * 관심도서 추가
	 */
	public static void AddFavoriteBook(AddFavoriteBookInputDto ip) {
		bookService.AddFavoriteBook(ip);
		EndView.printMessage("관심 도서에 추가되었습니다.");
	}
	
	/**
	 * 관심도서 조회
	 */
	public static void ViewFavoriteBook(ViewFavoriteBookInputDto ip) {
		List<ViewFavoriteBookOutputDto> favorlist = bookService.ViewFavoriteBook(ip);
		EndView.printFavorBook(favorlist);
	}
	/**
	 * 관심도서 삭제
	 */
	public static void DeleteFavoriteBook(DeleteFavoriteBookInputDto ip) {
		bookService.DeleteFavoriteBook(ip);
		EndView.printMessage("관심도서가 삭제되었습니다.");
	}
	/**
	 * 도서 요청
	 */
	public static void RequestBook(RequestBookInputDto ip) {
		bookService.RequestBook(ip);
		EndView.printMessage("도서가 요청되었습니다.");
	}
	/**
	 * 도서 요청 내역 확인
	 */
	public static void ViewBookRequests(ViewBookRequestsInputDto ip) {
		bookService.ViewBookRequests(ip);
	}
	/**
	 * 도서 대여 내역 확인
	 */
	public static void viewLoanHistory(ViewLoanHistoryInputDto ip) {
		List<ViewLoanHistoryOutputDto> list = bookService.ViewLoanHistory(ip);
		EndView.printLoan(list);
	}
	/**
	 * 도서 대여
	 */
	public static void loanBook(CheckBookAvailabilityBySeqInputDto ip) {
		CheckBookAvailabilityBySeqOutputDto op;
		op = bookService.CheckBookAvailabilityBySeq(ip);
		System.out.println("반납 날짜: "+op.getReturndate());
		System.out.println("남은 도서 대여 권수: "+op.getBookposbnum());
	}
	/**
	 * 도서 추가(관리자)
	 */
	public static void registerBook(RegisterBookUnrequestedInputDto ip) {
		bookService.RegisterBookUnrequested(ip);
		EndView.printMessage("도서가 추가되었습니다.");
	}
	/**
	 * 도서 추천
	 */
	public static void recommendBook(RecommendBookInputDto ip) {
		List<RecommendBookOutputDto> list = bookService.RecommendBook(ip);
		EndView.printRecommend(list);
	}
	/**
	 * 도서 반납
	 */
	public static void returnBook(ReturnBookBySeqInputDto ip) {
		ReturnBookBySeqOutputDto op = bookService.ReturnBookBySeq(ip);
		System.out.println("대여 날짜: "+op.getRentdate());
		System.out.println("반납 날짜: "+op.getReturndate());
	}
	
}
