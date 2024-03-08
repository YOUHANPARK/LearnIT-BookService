package book.dto;

import java.util.Date;

public class BookDto {
	
	/**
	 * 도서(제목)검색 
	 */
	public static class SearchBookByTitleInputDto{
		String title;
		int page;
		
		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
		

		public int getPage() {
			return page;
		}

		public void setPage(int page) {
			this.page = page;
		}

		public SearchBookByTitleInputDto() {
			super();
		}

		public SearchBookByTitleInputDto(String title, int page) {
			super();
			this.title = title;
			this.page = page;
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
			builder.append("[책 번호=");
			builder.append(bookseq);
			builder.append(", 책 제목=");
			builder.append(title);
			builder.append(", 청구기호=");
			builder.append(booknum);
			builder.append(", 출판사=");
			builder.append(publisher);
			builder.append(", 저자=");
			builder.append(author);
			builder.append(", 대여가능여부=");
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
		int page;

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}
		

        public SearchBookByCategoryInputDto() {
            super();
        }

        public SearchBookByCategoryInputDto(String category, int page) {
            super();
            this.category = category;
            this.page = page;
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

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[책 번호= ");
			builder.append(bookseq);
			builder.append(", 책 제목= ");
			builder.append(title);
			builder.append(", 청구 기호= ");
			builder.append(callnum);
			builder.append(", 출판사= ");
			builder.append(publisher);
			builder.append(", 저자= ");
			builder.append(author);
			builder.append(", 대여가능여부= ");
			builder.append(bookposb);
			builder.append("]");
			return builder.toString();
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
			builder.append("[bookseq = ");
			builder.append(bookseq);
			builder.append(", 책 제목 = ");
			builder.append(title);
			builder.append(", 청구기호 = ");
			builder.append(callnum);
			builder.append(", 출판사 = ");
			builder.append(publisher);
			builder.append(", 저자 = ");
			builder.append(author);
			builder.append(", 책 소개 = ");
			builder.append(intro);
			builder.append(", 대여 가능 여부 = ");
			builder.append(bookposb);
			builder.append(", 출판연도 = ");
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
	
	/**
	 * 도서 대여 Input
	 */
	public static class CheckBookAvailabilityBySeqInputDto{
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
		public CheckBookAvailabilityBySeqInputDto() {
			super();
		}
		public CheckBookAvailabilityBySeqInputDto(long bookseq, long userseq) {
			super();
			this.bookseq = bookseq;
			this.userseq = userseq;
		}
		
		
	}
	/**
	 * 도서 대여 Output
	 */
	public static class CheckBookAvailabilityBySeqOutputDto{
		Date returndate;
		int bookposbnum;
		
		public Date getReturndate() {
			return returndate;
		}
		public void setReturndate(Date returndate) {
			this.returndate = returndate;
		}
		public int getBookposbnum() {
			return bookposbnum;
		}
		public void setBookposbnum(int bookposbnum) {
			this.bookposbnum = bookposbnum;
		}
		public CheckBookAvailabilityBySeqOutputDto() {
			super();
		}
		public CheckBookAvailabilityBySeqOutputDto(Date returndate, int bookposbnum) {
			super();
			this.returndate = returndate;
			this.bookposbnum = bookposbnum;
		}
		
		
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
		
		public long getUserseq() {
			return userseq;
		}
		public void setUserseq(long userseq) {
			this.userseq = userseq;
		}
		
		public RequestBookInputDto() {
			super();
		}
		public RequestBookInputDto(String title, String publisher, String author, long userseq) {
			super();
			this.title = title;
			this.publisher = publisher;
			this.author = author;
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
	
	/**
	 * 도서 요청 처리(관리자)
	 */
	public static class ManageBookRequestInputDto{
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
	public static class ManageBookRequestOutputDto{
		Date requestdate;
		String requeststatus;
		String addtitle;
		String addauthor;
		long requestuserseq;
		public Date getRequestdate() {
			return requestdate;
		}
		public void setRequestdate(Date requestdate) {
			this.requestdate = requestdate;
		}
		public String getRequeststatus() {
			return requeststatus;
		}
		public void setRequeststatus(String requeststatus) {
			this.requeststatus = requeststatus;
		}
		public String getAddtitle() {
			return addtitle;
		}
		public void setAddtitle(String addtitle) {
			this.addtitle = addtitle;
		}
		public String getAddauthor() {
			return addauthor;
		}
		public void setAddauthor(String addauthor) {
			this.addauthor = addauthor;
		}
		public long getRequestuserseq() {
			return requestuserseq;
		}
		public void setRequestuserseq(long requestuserseq) {
			this.requestuserseq = requestuserseq;
		}
		public ManageBookRequestOutputDto() {
			super();
		}
		public ManageBookRequestOutputDto(Date requestdate, String requeststatus, String addtitle, String addauthor,
				long requestuserseq) {
			super();
			this.requestdate = requestdate;
			this.requeststatus = requeststatus;
			this.addtitle = addtitle;
			this.addauthor = addauthor;
			this.requestuserseq = requestuserseq;
		}
		
		
	}
	
	/**
	 * 반납 Input
	 */
	public static class ReturnBookBySeqInputDto{
		long bookseq;
		long userseq;
		public ReturnBookBySeqInputDto() {
			super();
			
		}
		public ReturnBookBySeqInputDto(long bookseq, long userseq) {
			super();
			this.bookseq = bookseq;
			this.userseq = userseq;
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
		
		
	}
	
	/**
	 * 반납 Output
	 */
	public static class ReturnBookBySeqOutputDto{
		Date rentdate;
		Date returndate;
		
		
		public ReturnBookBySeqOutputDto() {
			super();
		}
		
		public ReturnBookBySeqOutputDto(Date rentdate, Date returndate) {
			super();
			this.rentdate = rentdate;
			this.returndate = returndate;
		}
		public Date getRentdate() {
			return rentdate;
		}
		public void setRentdate(Date rentdate) {
			this.rentdate = rentdate;
		}
		public Date getReturndate() {
			return returndate;
		}
		public void setReturndate(Date returndate) {
			this.returndate = returndate;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[대여 날짜=");
			builder.append(rentdate);
			builder.append(", 반납 날짜=");
			builder.append(returndate);
			builder.append("]");
			return builder.toString();
		}
		
		
			
	}
	
	public static class ExtendBookLoanBySeqInputDto{
		long bookseq;
		long userseq;
	}
	public static class ExtendBookLoanBySeqOutputDto{
		Date returndate;
	}
	
	/**
	 * 별점 등록
	 */
	public static class RateBookInputDto{
		int score;
		long bookseq;
		long userseq;
		
		public int getScore() {
			return score;
		}
		public void setScore(int score) {
			this.score = score;
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
		public RateBookInputDto() {
			super();
		}
		public RateBookInputDto(int score, long bookseq, long userseq) {
			super();
			this.score = score;
			this.bookseq = bookseq;
			this.userseq = userseq;
		}
		
		
	}
	
	public static class ViewLoanHistoryInputDto{
		long userseq;
		
		public long getUserseq() {
			return userseq;
		}

		public void setUserseq(long userseq) {
			this.userseq = userseq;
		}

		public ViewLoanHistoryInputDto(long userseq) {
			super();
			this.userseq = userseq;
		}
		
		
	}
	public static class ViewLoanHistoryOutputDto{
		String title;
		String booknum;
		String publisher;
		String author;
		Date pubyear;
		Date loandate;
		Date returndate;
		
		public ViewLoanHistoryOutputDto() {
			super();
		}

		public ViewLoanHistoryOutputDto(String title, String booknum, String publisher, String author, Date pubyear,
				Date loandate, Date returndate) {
			super();
			this.title = title;
			this.booknum = booknum;
			this.publisher = publisher;
			this.author = author;
			this.pubyear = pubyear;
			this.loandate = loandate;
			this.returndate = returndate;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[책 제목 = ");
			builder.append(title);
			builder.append(", 청구 기호 = ");
			builder.append(booknum);
			builder.append(", 출판사 = ");
			builder.append(publisher);
			builder.append(", 저자 = ");
			builder.append(author);
			builder.append(", 발행연도 = ");
			builder.append(pubyear);
			builder.append(", 대출 일자 = ");
			builder.append(loandate);
			builder.append(", 반납 일자 =");
			builder.append(returndate);
			builder.append("]");
			return builder.toString();
		}
		
		
	}
	
	public static class RecommendBookInputDto{
		long userseq;
		
		public RecommendBookInputDto() {
			
		}

		public RecommendBookInputDto(long userseq) {
			
			this.userseq = userseq;
		}
		public long getUserseq() {
			return userseq;
		}
		public void setUserseq(long userseq) {
			this.userseq = userseq;
		}
		
		
		
	}
	public static class RecommendBookOutputDto{
		int score;
		String title;
		String booknum;
		String publisher;
		String author;
		Date pubyear;
		int bookposb;
		
		public RecommendBookOutputDto() {
			super();
		}

		public RecommendBookOutputDto(int score, String title, String booknum, String publisher, String author, Date pubyear,
				int bookposb) {
			super();
			this.score = score;
			this.title = title;
			this.booknum = booknum;
			this.publisher = publisher;
			this.author = author;
			this.pubyear = pubyear;
			this.bookposb = bookposb;
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

		@Override
		public String toString() {
		    String loanStatus = bookposb == 1 ? "가능" : "불가능";
		    return String.format("별점 = %-4s, 제목 = %-25s, 청구기호 = %-8s, 출판사 = %-15s, 작가 = %-4s, 출판연도 = %-4s, 대여가능여부 = %-3s",
		                         score, title, booknum, publisher, author, pubyear, loanStatus);
		}


		
	}
	
	
}

