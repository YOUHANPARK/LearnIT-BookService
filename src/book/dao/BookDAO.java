package book.dao;

import java.util.List;

import book.dto.Book;
import book.dto.BookDto.SearchBookByTitleInputDto;

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
	
}
