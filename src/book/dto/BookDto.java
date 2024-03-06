package book.dto;

import java.util.Date;

public class BookDto {
	
	/**
	 * 도서(제목)검색 
	 */
	public static class SearchBookByTitleInputDto{
		String title;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public SearchBookByTitleInputDto() {
			super();
		}

		public SearchBookByTitleInputDto(String title) {
			super();
			this.title = title;
		}
		
		
		
	}
	public static class SearchBookByTitleOutputDto {
		long bookseq;
		String title;
		String booknum;
		String publisher;
		String author;
		int bookposb;
		
		
		public SearchBookByTitleOutputDto() {
			super();
		}
		public SearchBookByTitleOutputDto(long bookseq, String title, String booknum, String publisher, String author,
				int bookposb) {
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
		public int getBookposb() {
			return bookposb;
		}
		public void setBookposb(int bookposb) {
			this.bookposb = bookposb;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("SearchBookByTitleOutputDto [bookseq=");
			builder.append(bookseq);
			builder.append(", title=");
			builder.append(title);
			builder.append(", booknum=");
			builder.append(booknum);
			builder.append(", publisher=");
			builder.append(publisher);
			builder.append(", author=");
			builder.append(author);
			builder.append(", bookposb=");
			builder.append(bookposb);
			builder.append("]");
			return builder.toString();
		}
		
		
		
		
	}
	
	/**
	 * 도서(카테고리)검색
	 */
	public static class SearchBookByCategoryInputDto {
		String category;

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}
		
	}
	public static class SearchBookByCategoryOutputDto {
		long bookseq;
		String title;
		String callnum;
		String publisher;
		String author;
		int bookposb;
		
		public SearchBookByCategoryOutputDto() {
			super();
		}

		public SearchBookByCategoryOutputDto(long bookseq, String title, String callnum, String publisher,
				String author, int bookposb) {
			super();
			this.bookseq = bookseq;
			this.title = title;
			this.callnum = callnum;
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

		public String getCallnum() {
			return callnum;
		}

		public void setCallnum(String callnum) {
			this.callnum = callnum;
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

		public int isBookposb() {
			return bookposb;
		}

		public void setBookposb(int bookposb) {
			this.bookposb = bookposb;
		}
		
		
	}
	
	/**
	 * 도서 상세 검색
	 */
	public static class SearchBookBySeqInputDto{
		long bookseq;

		public long getBookseq() {
			return bookseq;
		}

		public void setBookseq(long bookseq) {
			this.bookseq = bookseq;
		}

		public SearchBookBySeqInputDto(long bookseq) {
			super();
			this.bookseq = bookseq;
		}
		
		
		
	}
	public static class SearchBookBySeqOutputDto{
		long bookseq;
		String title;
		String callnum;
		String publisher;
		String author;
		String intro;
		int bookposb;
		Date pubyear;
		
		public SearchBookBySeqOutputDto() {
			super();
		}

		public SearchBookBySeqOutputDto(long bookseq, String title, String callnum, String publisher, String author,
				String intro, int bookposb, Date pubyear) {
			super();
			this.bookseq = bookseq;
			this.title = title;
			this.callnum = callnum;
			this.publisher = publisher;
			this.author = author;
			this.intro = intro;
			this.bookposb = bookposb;
			this.pubyear = pubyear;
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

		public String getCallnum() {
			return callnum;
		}

		public void setCallnum(String callnum) {
			this.callnum = callnum;
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

		public String getIntro() {
			return intro;
		}

		public void setIntro(String intro) {
			this.intro = intro;
		}

		public int getBookposb() {
			return bookposb;
		}

		public void setBookposb(int bookposb) {
			this.bookposb = bookposb;
		}

		public Date getPubyear() {
			return pubyear;
		}

		public void setPubyear(Date pubyear) {
			this.pubyear = pubyear;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("SearchBookBySeqOutputDto [bookseq=");
			builder.append(bookseq);
			builder.append(", title=");
			builder.append(title);
			builder.append(", callnum=");
			builder.append(callnum);
			builder.append(", publisher=");
			builder.append(publisher);
			builder.append(", author=");
			builder.append(author);
			builder.append(", intro=");
			builder.append(intro);
			builder.append(", bookposb=");
			builder.append(bookposb);
			builder.append(", pubyear=");
			builder.append(pubyear);
			builder.append("]");
			return builder.toString();
		}
		
		
		
	}
	
	/**
	 * 관심도서 추가(생성)
	 */
	public static class AddFavoriteBookInputDto{
		long userseq;
		long bookseq;
		
		public AddFavoriteBookInputDto() {
			super();
		}
		public AddFavoriteBookInputDto(long userseq, long bookseq) {
			super();
			this.userseq = userseq;
			this.bookseq = bookseq;
		}
		public long getUserseq() {
			return userseq;
		}
		public void setUserseq(long userseq) {
			this.userseq = userseq;
		}
		public long getBookseq() {
			return bookseq;
		}
		public void setBookseq(long bookseq) {
			this.bookseq = bookseq;
		}
		
		
	}
	
	/**
	 * 관심도서 조회
	 */
	public static class ViewFavoriteBookInputDto{
		long userseq;

		public long getUserseq() {
			return userseq;
		}

		public void setUserseq(long userseq) {
			this.userseq = userseq;
		}

		public ViewFavoriteBookInputDto(long userseq) {
			super();
			this.userseq = userseq;
		}
		
		
		
	}
	public static class ViewFavoriteBookOutputDto{
		String title;
		String callnum;
		String publisher;
		String author;
		int bookposb;
		
		public ViewFavoriteBookOutputDto() {
			super();
		}

		public ViewFavoriteBookOutputDto(String title, String callnum, String publisher, String author, int bookposb) {
			super();
			this.title = title;
			this.callnum = callnum;
			this.publisher = publisher;
			this.author = author;
			this.bookposb = bookposb;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("ViewFavoriteBookOutputDto [title=");
			builder.append(title);
			builder.append(", callnum=");
			builder.append(callnum);
			builder.append(", publisher=");
			builder.append(publisher);
			builder.append(", author=");
			builder.append(author);
			builder.append(", bookposb=");
			builder.append(bookposb);
			builder.append("]");
			return builder.toString();
		}
		
		
		
		
	}
	
	/**
	 * 관심도서 삭제
	 */
	public static class DeleteFavoriteBookInputDto{
		String title;
		long userseq;
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public long getUserseq() {
			return userseq;
		}
		public void setUserseq(long userseq) {
			this.userseq = userseq;
		}
		
		public DeleteFavoriteBookInputDto() {
			super();
		}
		public DeleteFavoriteBookInputDto(String title, long userseq) {
			super();
			this.title = title;
			this.userseq = userseq;
		}
		
		
	}
	
	
	public static class CheckBookAvailabilityBySeqInputDto{
		long bookseq;
		long userseq;
	}
	public static class CheckBookAvailabilityBySeqOutputDto{
		Date returndate;
		int bookposbnum;
	}
	
	/**
	 * (요청받지 않은) 도서 등록
	 */
	public static class RegisterBookUnrequestedInputDto{
		String title;
		String callnum;
		String publisher;
		String intro;
		String author;
		Date pubyear;
		int loanposb;
		long userseq;
		String cartname;
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getBooknum() {
			return callnum;
		}
		public void setBooknum(String callnum) {
			this.callnum = callnum;
		}
		public String getPublisher() {
			return publisher;
		}
		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}
		public String getIntro() {
			return intro;
		}
		public void setIntro(String intro) {
			this.intro = intro;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public Date getPubyear() {
			return pubyear;
		}
		public void setPubyear(Date pubyear) {
			this.pubyear = pubyear;
		}
		public int getloanposb() {
			return loanposb;
		}
		public void setloanposb(int loanposb) {
			this.loanposb = loanposb;
		}
		public long getUserseq() {
			return userseq;
		}
		public void setUserseq(long userseq) {
			this.userseq = userseq;
		}
		public String getCartname() {
			return cartname;
		}
		public void setCartname(String cartname) {
			this.cartname = cartname;
		}
		
		public RegisterBookUnrequestedInputDto() {
			super();
		}
		public RegisterBookUnrequestedInputDto(String title, String callnum, String publisher, String intro,
				String author, Date pubyear, int loanposb, long userseq, String cartname) {
			super();
			this.title = title;
			this.callnum = callnum;
			this.publisher = publisher;
			this.intro = intro;
			this.author = author;
			this.pubyear = pubyear;
			this.loanposb = loanposb;
			this.userseq = userseq;
			this.cartname = cartname;
		}
		
		
		
	}
	
	/**
	 * (요청받은) 책 등록
	 */
	public static class RegisterBookRequestedInputDto{
		String title;
		String callnum;
		String publisher;
		String intro;
		String author;
		Date pubyear;
		int bookposb;
		long userseq;
		String cartname;
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getCallnum() {
			return callnum;
		}
		public void setCallnum(String callnum) {
			this.callnum = callnum;
		}
		public String getPublisher() {
			return publisher;
		}
		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}
		public String getIntro() {
			return intro;
		}
		public void setIntro(String intro) {
			this.intro = intro;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public Date getPubyear() {
			return pubyear;
		}
		public void setPubyear(Date pubyear) {
			this.pubyear = pubyear;
		}
		public int getBookposb() {
			return bookposb;
		}
		public void setBookposb(int bookposb) {
			this.bookposb = bookposb;
		}
		public long getUserseq() {
			return userseq;
		}
		public void setUserseq(long userseq) {
			this.userseq = userseq;
		}
		public String getCartname() {
			return cartname;
		}
		public void setCartname(String cartname) {
			this.cartname = cartname;
		}
		
		
	}
	
	/**
	 * 도서 수정
	 */
	public static class UpdateBookBySeqInputDto{
		String title;
		String booknum;
		String publisher;
		String author;
		Date pubyear;
		long bookseq;
		long userseq;
		
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
		public Date getPubyear() {
			return pubyear;
		}
		public void setPubyear(Date pubyear) {
			this.pubyear = pubyear;
		}
		public long getBookseq() {
			return bookseq;
		}
		public void setBookseq(long bookseq) {
			this.bookseq = bookseq;
		}
		public long getUserseq() {
			return userseq;
		}
		public void setUserseq(long userseq) {
			this.userseq = userseq;
		}
		public UpdateBookBySeqInputDto() {
			super();
		}
		
		public UpdateBookBySeqInputDto(String title, String booknum, String publisher, String author, Date pubyear,
				long bookseq) {
			super();
			this.title = title;
			this.booknum = booknum;
			this.publisher = publisher;
			this.author = author;
			this.pubyear = pubyear;
			this.bookseq = bookseq;
		}
	
	}
	
	public static class DeleteBookInputDto{
		long bookseq;
		long userseq;
		public long getBookseq() {
			return bookseq;
		}
		public void setBookseq(long bookseq) {
			this.bookseq = bookseq;
		}
		public long getUserseq() {
			return userseq;
		}
		public void setUserseq(long userseq) {
			this.userseq = userseq;
		}
		public DeleteBookInputDto() {
			super();
		}
		public DeleteBookInputDto(long bookseq) {
			super();
			this.bookseq = bookseq;
		}
		
		
	}
	
	public static class RequestBookInputDto{
		String title;
		String publisher;
		String author;
		Date pubyear;
		long userseq;
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
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
		public Date getPubyear() {
			return pubyear;
		}
		public void setPubyear(Date pubyear) {
			this.pubyear = pubyear;
		}
		public long getUserseq() {
			return userseq;
		}
		public void setUserseq(long userseq) {
			this.userseq = userseq;
		}
		
		
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

