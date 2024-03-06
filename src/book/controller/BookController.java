package book.controller;

import java.util.List;

import book.dto.BookDto;
import book.dto.BookDto.AddFavoriteBookInputDto;
import book.dto.BookDto.SearchBookByCategoryInputDto;
import book.dto.BookDto.SearchBookByCategoryOutputDto;
import book.dto.BookDto.SearchBookBySeqInputDto;
import book.dto.BookDto.SearchBookBySeqOutputDto;
import book.dto.BookDto.SearchBookByTitleInputDto;
import book.dto.BookDto.SearchBookByTitleOutputDto;
import book.service.BookService;
import view.EndView;



public class BookController {
	static BookService bookService;
	
	
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
}
