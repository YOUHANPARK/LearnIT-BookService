package view;
import java.util.List;

import book.dto.BookDto;
import book.dto.BookDto.SearchBookByCategoryOutputDto;
import book.dto.BookDto.SearchBookBySeqOutputDto;
import book.dto.BookDto.SearchBookByTitleOutputDto;

public class EndView {
	
	/**
	 * 도서 제목으로 검색
	 */
	public static void printBookByTitle(List<SearchBookByTitleOutputDto> list) {
		System.out.println("---------제목으로 검색한 결과입니다.-------------");
		for(SearchBookByTitleOutputDto books : list) {
			System.out.println(books);
		}
		System.out.println();
	}
	
	/**
	 * 도서 카테고리로 검색
	 */
	public static void printBookByCategory(List<SearchBookByCategoryOutputDto> list) {
		System.out.println("---------카테고리로 검색한 결과입니다.-------------");
		for(SearchBookByCategoryOutputDto books : list) {
			System.out.println(books);
		}
		System.out.println();
	}
	
	/**
	 * 도서 상세 검색
	 */
	public static void printBookBySeq(SearchBookBySeqOutputDto bookdto) {
		System.out.println("---------도서 상세 검색 결과입니다.-------------");
		
		System.out.println(bookdto);
		
		System.out.println();
	}
	
	
	
	/**
     * 성공에 관련된 메세지 출력 
     * @param message
     */
    public static void printMessage(String message) {
         System.out.println(message+"\n");
    }
}