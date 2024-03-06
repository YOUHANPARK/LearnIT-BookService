package book.dao;

import java.util.List;

import book.dto.Book;
import book.dto.BookDto.AddFavoriteBookInputDto;
import book.dto.BookDto.CheckBookAvailabilityBySeqInputDto;
import book.dto.BookDto.CheckBookAvailabilityBySeqOutputDto;
import book.dto.BookDto.DeleteBookInputDto;
import book.dto.BookDto.DeleteFavoriteBookInputDto;
import book.dto.BookDto.ManageBookRequestInputDto;
import book.dto.BookDto.ManageBookRequestOutputDto;
import book.dto.BookDto.RateBookInputDto;
import book.dto.BookDto.RecommendBookInputDto;
import book.dto.BookDto.RecommendBookOutputDto;
import book.dto.BookDto.RegisterBookRequestedInputDto;
import book.dto.BookDto.RegisterBookUnrequestedInputDto;
import book.dto.BookDto.RequestBookInputDto;
import book.dto.BookDto.SearchBookByCategoryInputDto;
import book.dto.BookDto.SearchBookBySeqInputDto;
import book.dto.BookDto.SearchBookBySeqOutputDto;
import book.dto.BookDto.SearchBookByTitleInputDto;
import book.dto.BookDto.UpdateBookBySeqInputDto;
import book.dto.BookDto.ViewFavoriteBookInputDto;
import book.dto.BookDto.ViewLoanHistoryInputDto;
import book.dto.BookDto.ViewLoanHistoryOutputDto;

public interface BookDAO {
	
//	List<SearchBookByTitleOutputDto> searchBookByTitle(SearchBookByTitleInputDto ip) throws SQLException;
//	
//	List<SearchBookByCategoryOutputDto> SearchBookByCategory(SearchBookByCategoryInputDto ip) throws SQLException;
//	
//	SearchBookBySeqOutputDto SearchBookBySeq(SearchBookBySeqInputDto ip) throws SQLException;
//	
//	void AddFavoriteBook(AddFavoriteBookInputDto ip) throws SQLException;
//	
//	List<ViewFavoriteBookOutputDto> ViewFavoriteBook(ViewFavoriteBookInputDto ip) throws SQLException;
//	
//	void DeleteFavoriteBook(DeleteFavoriteBookInputDto ip) throws SQLException;
//	
//	CheckBookAvailabilityBySeqOutputDto CheckBookAvailabilityBySeq(CheckBookAvailabilityBySeqInputDto ip) throws SQLException;
//	
//	void RegisterBookUnrequested(RegisterBookUnrequestedInputDto ip) throws SQLException;
//	
//	void RegisterBookRequested(RegisterBookRequestedInputDto ip) throws SQLException;
//	
//	void UpdateBookBySeq(UpdateBookBySeqInputDto ip)throws SQLException;
//	
//	void DeleteBook(DeleteBookInputDto ip) throws SQLException;
//	
//	void RequestBook(RequestBookInputDto ip) throws SQLException;
//	
//	ViewBookRequestsOutputDto ViewBookRequests(ViewBookRequestsInputDto ip) throws SQLException;
//	
//	ManageBookRequestOutputDto ManageBookRequest(ManageBookRequestInputDto ip) throws SQLException;
//	
//	ReturnBookBySeqOutputDto ReturnBookBySeq(ReturnBookBySeqInputDto ip)throws SQLException;
//	
//	ExtendBookLoanBySeqOutputDto ExtendBookLoanBySeq(ExtendBookLoanBySeqInputDto ip)throws SQLException;
//	
//	void RateBook(RateBookInputDto ip) throws SQLException;
//	
//	List<ViewLoanHistoryOutputDto> ViewLoanHistory(ViewLoanHistoryInputDto ip) throws SQLException;
//	
//	List<RecommendBookOutputDto> RecommendBook(RecommendBookInputDto ip) throws SQLException;
	
	List<Book> findAllBook();
	List<Book> findTitleBook(SearchBookByTitleInputDto searchbook);
	List<Book> findCategoryBook(SearchBookByCategoryInputDto searchbook);
	
	SearchBookBySeqOutputDto findSeqBook(SearchBookBySeqInputDto searchbook);
	void addFBook(AddFavoriteBookInputDto addbook);
	List<Book> findAllFBook(ViewFavoriteBookInputDto searchfbook);
	void delFBook(DeleteFavoriteBookInputDto delbook);
	
	CheckBookAvailabilityBySeqOutputDto checkBook(CheckBookAvailabilityBySeqInputDto checkbook);
	
	void registerUnreqBook(RegisterBookUnrequestedInputDto registerbook);
	void registerReqBook(RegisterBookRequestedInputDto registerbook);
	
	void updateBook(UpdateBookBySeqInputDto updatebook);
	void deleteBook(DeleteBookInputDto deletebook);
	
	void requestBook(RequestBookInputDto requestbook);
	
	ManageBookRequestOutputDto manageRequest(ManageBookRequestInputDto managebook);
	
	
	
	void rateBook(RateBookInputDto ratebook);
	
	List<ViewLoanHistoryOutputDto> viewLoan(ViewLoanHistoryInputDto loanbook);
	
	List<RecommendBookOutputDto> recommendBook(RecommendBookInputDto recommendbook);
}
