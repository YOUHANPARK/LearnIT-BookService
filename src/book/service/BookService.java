package book.service;

import java.util.List;

import book.dto.BookDto.AddFavoriteBookInputDto;
import book.dto.BookDto.CheckBookAvailabilityBySeqInputDto;
import book.dto.BookDto.CheckBookAvailabilityBySeqOutputDto;
import book.dto.BookDto.DeleteBookInputDto;
import book.dto.BookDto.DeleteFavoriteBookInputDto;
import book.dto.BookDto.ExtendBookLoanBySeqInputDto;
import book.dto.BookDto.ExtendBookLoanBySeqOutputDto;
import book.dto.BookDto.ManageBookRequestInputDto;
import book.dto.BookDto.ManageBookRequestOutputDto;
import book.dto.BookDto.RateBookInputDto;
import book.dto.BookDto.RecommendBookInputDto;
import book.dto.BookDto.RecommendBookOutputDto;
import book.dto.BookDto.RegisterBookRequestedInputDto;
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
import book.dto.BookDto.UpdateBookBySeqInputDto;
import book.dto.BookDto.ViewBookRequestsInputDto;
import book.dto.BookDto.ViewBookRequestsOutputDto;
import book.dto.BookDto.ViewFavoriteBookInputDto;
import book.dto.BookDto.ViewFavoriteBookOutputDto;
import book.dto.BookDto.ViewLoanHistoryInputDto;
import book.dto.BookDto.ViewLoanHistoryOutputDto;

public interface BookService {
	
	List<SearchBookByTitleOutputDto> SearchBookByTitle(SearchBookByTitleInputDto ip);
	
	List<SearchBookByCategoryOutputDto> SearchBookByCategory(SearchBookByCategoryInputDto ip);
	
	SearchBookBySeqOutputDto SearchBookBySeq(SearchBookBySeqInputDto ip);
	
	void AddFavoriteBook(AddFavoriteBookInputDto ip);
	
	List<ViewFavoriteBookOutputDto> ViewFavoriteBook(ViewFavoriteBookInputDto ip);
	
	void DeleteFavoriteBook(DeleteFavoriteBookInputDto ip);
	
	CheckBookAvailabilityBySeqOutputDto CheckBookAvailabilityBySeq(CheckBookAvailabilityBySeqInputDto ip);
	
	void RegisterBookUnrequested(RegisterBookUnrequestedInputDto ip);
	
	void RegisterBookRequested(RegisterBookRequestedInputDto ip);
	
	void UpdateBookBySeq(UpdateBookBySeqInputDto ip);
	
	void DeleteBook(DeleteBookInputDto ip);
	
	void RequestBook(RequestBookInputDto ip);
	
	ViewBookRequestsOutputDto ViewBookRequests(ViewBookRequestsInputDto ip);
	
	ManageBookRequestOutputDto ManageBookRequest(ManageBookRequestInputDto ip);
	
	ReturnBookBySeqOutputDto ReturnBookBySeq(ReturnBookBySeqInputDto ip);
	
	ExtendBookLoanBySeqOutputDto ExtendBookLoanBySeq(ExtendBookLoanBySeqInputDto ip);
	
	void RateBook(RateBookInputDto ip);
	
	List<ViewLoanHistoryOutputDto> ViewLoanHistory(ViewLoanHistoryInputDto ip);
	
	List<RecommendBookOutputDto> RecommendBook(RecommendBookInputDto ip);
	
}
