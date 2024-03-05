package book.dao;

import java.sql.SQLException;
import java.util.List;

import book.dto.BookDto.AddFavoriteBookInputDto;
import book.dto.BookDto.DeleteBookInputDto;
import book.dto.BookDto.DeleteFavoriteBookInputDto;
import book.dto.BookDto.ManageBookRequestInputDto;
import book.dto.BookDto.ManageBookRequestOutputDto;
import book.dto.BookDto.RecommendBookInputDto;
import book.dto.BookDto.RecommendBookOutputDto;
import book.dto.BookDto.RequestBookInputDto;
import book.dto.BookDto.SearchBookByCategoryInputDto;
import book.dto.BookDto.SearchBookByCategoryOutputDto;
import book.dto.BookDto.SearchBookBySeqInputDto;
import book.dto.BookDto.SearchBookBySeqOutputDto;
import book.dto.BookDto.SearchBookByTitleInputDto;
import book.dto.BookDto.SearchBookByTitleOutputDto;
import book.dto.BookDto.ViewBookRequestsInputDto;
import book.dto.BookDto.ViewBookRequestsOutputDto;
import book.dto.BookDto.ViewFavoriteBookInputDto;
import book.dto.BookDto.ViewFavoriteBookOutputDto;
import book.dto.BookDto.ViewLoanHistoryInputDto;
import book.dto.BookDto.ViewLoanHistoryOutputDto;

public interface BookDAO {
	
	List<SearchBookByTitleOutputDto> searchBookByTitle(SearchBookByTitleInputDto ip) throws SQLException;
	
	List<SearchBookByCategoryOutputDto> SearchBookByCategory(SearchBookByCategoryInputDto ip) throws SQLException;
	
	SearchBookBySeqOutputDto SearchBookBySeq(SearchBookBySeqInputDto ip) throws SQLException;
	
	void AddFavoriteBook(AddFavoriteBookInputDto ip) throws SQLException;
	
	List<ViewFavoriteBookOutputDto> ViewFavoriteBook(ViewFavoriteBookInputDto ip) throws SQLException;
	
	void DeleteFavoriteBook(DeleteFavoriteBookInputDto ip) throws SQLException;
	
	void DeleteBook(DeleteBookInputDto ip) throws SQLException;
	
	void RequestBook(RequestBookInputDto ip) throws SQLException;
	
	ViewBookRequestsOutputDto ViewBookRequests(ViewBookRequestsInputDto ip) throws SQLException;
	
	ManageBookRequestOutputDto ManageBookRequest(ManageBookRequestInputDto ip) throws SQLException;
	
	List<ViewLoanHistoryOutputDto> ViewLoanHistory(ViewLoanHistoryInputDto ip) throws SQLException;
	
	List<RecommendBookOutputDto> RecommendBook(RecommendBookInputDto ip) throws SQLException;
	
}
