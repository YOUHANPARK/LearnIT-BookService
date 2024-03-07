package book.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import book.dao.BookDAO;
import book.dto.Book;
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
import book.service.BookService;

public class BookServiceImpl implements BookService{
	
	

	public BookServiceImpl() {
		this.bookDAO = null;	
	}

	private final BookDAO bookDAO;
	
	public BookServiceImpl(BookDAO bookDAO){
		this.bookDAO = bookDAO;
		
	}
	
	
	
	
	@Override
	public List<SearchBookByTitleOutputDto> SearchBookByTitle(SearchBookByTitleInputDto ip) {
		//ip.setTitle("마인크래프트");
		List<SearchBookByTitleOutputDto> result = new ArrayList<>();
		bookDAO.findTitleBook(ip).forEach(b -> result.add(new SearchBookByTitleOutputDto(b.getBookseq(), b.getTitle(), b.getCallnum(), b.getPublisher(), b.getAuthor(), b.getLoanposb())));
		return result;
	}

	@Override
	public List<SearchBookByCategoryOutputDto> SearchBookByCategory(SearchBookByCategoryInputDto ip) {
		List<SearchBookByCategoryOutputDto> result = new ArrayList<>();
		bookDAO.findCategoryBook(ip).forEach(b->result.add(new SearchBookByCategoryOutputDto(b.getBookseq(), b.getTitle(), b.getCallnum(), b.getPublisher(), b.getAuthor(), b.getLoanposb())));
		return result;
	}

	@Override
	public SearchBookBySeqOutputDto SearchBookBySeq(SearchBookBySeqInputDto ip) {
		SearchBookBySeqOutputDto result = new SearchBookBySeqOutputDto();
		result = bookDAO.findSeqBook(ip);
		return result;
	}

	@Override
	public void AddFavoriteBook(AddFavoriteBookInputDto ip) {
		bookDAO.addFBook(ip);
		
	}

	@Override
	public List<ViewFavoriteBookOutputDto> ViewFavoriteBook(ViewFavoriteBookInputDto ip) {
		List<ViewFavoriteBookOutputDto> result = new ArrayList<>();
		bookDAO.findAllFBook(ip).forEach(b->result.add(new ViewFavoriteBookOutputDto(b.getTitle(), b.getCallnum(), b.getPublisher(), b.getAuthor(), b.getLoanposb())));
		return result;
	}

	@Override
	public void DeleteFavoriteBook(DeleteFavoriteBookInputDto ip) {
		bookDAO.delFBook(ip);
		
	}
	
	/**
	 * 도서 대여
	 */
	@Override
	public CheckBookAvailabilityBySeqOutputDto CheckBookAvailabilityBySeq(CheckBookAvailabilityBySeqInputDto ip) {
		CheckBookAvailabilityBySeqOutputDto result = new CheckBookAvailabilityBySeqOutputDto();
		result = bookDAO.checkBook(ip);
		return result;
	}
	
	/**
	 * 반납
	 */
	@Override
	public ReturnBookBySeqOutputDto ReturnBookBySeq(ReturnBookBySeqInputDto ip) {
		ReturnBookBySeqOutputDto result = new ReturnBookBySeqOutputDto();
		result = bookDAO.returnBook(ip);
		return null;
	}
	
	@Override
	public void RegisterBookUnrequested(RegisterBookUnrequestedInputDto ip) {
		bookDAO.registerUnreqBook(ip);
		
	}

	@Override
	public void RegisterBookRequested(RegisterBookRequestedInputDto ip) {
		bookDAO.registerReqBook(ip);
		
	}

	@Override
	public void UpdateBookBySeq(UpdateBookBySeqInputDto ip) {
		bookDAO.updateBook(ip);
		
	}

	@Override
	public void DeleteBook(DeleteBookInputDto ip) {
		bookDAO.deleteBook(ip);
		
	}

	@Override
	public void RequestBook(RequestBookInputDto ip) {
		bookDAO.requestBook(ip);
		
	}

	@Override
	public ViewBookRequestsOutputDto ViewBookRequests(ViewBookRequestsInputDto ip) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManageBookRequestOutputDto ManageBookRequest(ManageBookRequestInputDto ip) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public ExtendBookLoanBySeqOutputDto ExtendBookLoanBySeq(ExtendBookLoanBySeqInputDto ip) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void RateBook(RateBookInputDto ip) {
		bookDAO.rateBook(ip);
		
	}

	@Override
	public List<ViewLoanHistoryOutputDto> ViewLoanHistory(ViewLoanHistoryInputDto ip) {
		List<ViewLoanHistoryOutputDto> loanlist = bookDAO.viewLoan(ip);
		return loanlist;
	}

	@Override
	public List<RecommendBookOutputDto> RecommendBook(RecommendBookInputDto ip) {
		return bookDAO.recommendBook(ip);
	}

}
