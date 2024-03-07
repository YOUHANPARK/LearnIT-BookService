package book.dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
import book.dto.BookDto.ReturnBookBySeqInputDto;
import book.dto.BookDto.ReturnBookBySeqOutputDto;
import book.dto.BookDto.SearchBookByCategoryInputDto;
import book.dto.BookDto.SearchBookBySeqInputDto;
import book.dto.BookDto.SearchBookBySeqOutputDto;
import book.dto.BookDto.SearchBookByTitleInputDto;
import book.dto.BookDto.UpdateBookBySeqInputDto;
import book.dto.BookDto.ViewFavoriteBookInputDto;
import book.dto.BookDto.ViewLoanHistoryInputDto;
import book.dto.BookDto.ViewLoanHistoryOutputDto;
import config.AppConfig;
import config.AppConfig.DBUtil;

public class BookDAOImpl implements BookDAO{

	@Override
	public List<Book> findAllBook() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<Book> booklist = new ArrayList<>();
		String sql = "select * from 책";
		
		try { 
			con = AppConfig.DBUtil.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Book book = new Book(rs.getLong(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getInt(7),rs.getDate(8),rs.getString(9));
				booklist.add(book);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.DbClose(con, st, rs);
		}
		
		return booklist;
	}
	
	@Override
	public List<Book> findTitleBook(SearchBookByTitleInputDto searchbook) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> booklist = new ArrayList<>();
		String sql = "SELECT Book_Seq, Book_Title, Call_Number, Publisher, Author, Loan_Possible FROM\r\n"
				+ "    (SELECT 책.*, DENSE_RANK() OVER(ORDER BY 책.book_title) AS rnum FROM 책 where book_title like ?)\r\n"
				+ "WHERE rnum >=? and rnum<=?";
		
		try { 
			con = AppConfig.DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			//System.out.println(searchbook.getTitle());
			ps.setString(1,"%"+searchbook.getTitle()+"%");
			ps.setInt(2,(searchbook.getPage()-1)*10+1);
			ps.setInt(3, searchbook.getPage()*10);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Book book = new Book(rs.getLong(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getInt(6));
				booklist.add(book);
				//System.out.println(book.getTitle());
			}
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.DbClose(con, ps, rs);
		}
		
		return booklist;
	}

	@Override
	public List<Book> findCategoryBook(SearchBookByCategoryInputDto searchbook) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> booklist = new ArrayList<>();
		String sql = "SELECT Book_Seq, Book_Title, Call_Number, Publisher, Author, Loan_Possible FROM\r\n"
				+ "    (SELECT 책.*, DENSE_RANK() OVER(ORDER BY 책.name) AS rnum FROM 책 where book_title like ?)\r\n"
				+ "WHERE rnum >=? and rnum<=?";
		
		try {
			con = AppConfig.DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, '%'+searchbook.getCategory()+'%');
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Book book = new Book(rs.getLong(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getInt(6));
				booklist.add(book);
			}
		}catch(Exception e) {
				e.printStackTrace();
		}finally {
				DBUtil.DbClose(con, ps, rs);
		}
		return booklist;
	}

	@Override
	public SearchBookBySeqOutputDto findSeqBook(SearchBookBySeqInputDto searchbook) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from 책 where book_seq = ?";
		SearchBookBySeqOutputDto op = null;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setLong(1, searchbook.getBookseq());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				op = new SearchBookBySeqOutputDto(rs.getLong(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getDate(8));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.DbClose(con, ps, rs);
		}
		return op;
	}
	
	@Override
	public void addFBook(AddFavoriteBookInputDto addbook) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into 관심도서 (book_seq, user_seq) values (?,?)";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setLong(1, addbook.getBookseq());
			ps.setLong(2, addbook.getUserseq());
			ps.executeQuery();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.DbClose(con, ps);
		}
		
	}

	@Override
	public List<Book> findAllFBook(ViewFavoriteBookInputDto searchfbook) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select book_title, call_number, publisher,author, loan_possible from 책 join 관심도서 using(book_seq) where user_seq = ?";
		List<Book> booklist = new ArrayList<>();
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setLong(1, searchfbook.getUserseq() );
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Book book = new Book(rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getInt(5));
				booklist.add(book);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.DbClose(con, ps, rs);
		}
		return booklist;
	}

	@Override
	public void delFBook(DeleteFavoriteBookInputDto delbook) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "delete from 관심도서 where book_seq = (select book_seq from 책 where book_title = ?) and user_seq =?";
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, delbook.getTitle());
			ps.setLong(2, delbook.getUserseq());
			rs = ps.executeQuery();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.DbClose(con, ps, rs);
		}
		
	}

	/*
	@Override
	public CheckBookAvailabilityBySeqOutputDto checkBook(CheckBookAvailabilityBySeqInputDto checkbook) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select loan_possible from 책 where book_seq=?";
		CheckBookAvailabilityBySeqOutputDto op;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setLong(1, checkbook.getBookseq());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if(rs.getInt(1)==1) {
					PreparedStatement ps2 = null;
					String sql2 = "insert into 대여 (rental_date,user_seq) values(select sysdate from dual,?)";
					ResultSet rs2 = null;
					try {
						ps2 = con.prepareStatement(sql2);
						ps.setLong(1, checkbook.getUserseq());
						rs2=ps.executeQuery();
						
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						DBUtil.DbClose(con, ps2);
					}
					
					PreparedStatement ps3 = null;
					ResultSet rs3 = null;
					String sql3 = "insert into 대여상세 (expectedreturn_date,book_seq,borrow_seq) values((select dateadd(day,14,(select sysdate from dual))),?,?)";
					try {
						ps3 = con.prepareStatement(sql3);
						ps3.setLong(2, checkbook.getBookseq());
						ps3.setLong(3, rs2.getLong(1));
						rs3 = ps3.executeQuery();
						
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						DBUtil.DbClose(con, ps3);
					}
				}
				
				op = new CheckBookAvailabilityBySeqOutputDto(rs.getDate(1),);
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.DbClose(con, ps, rs);
		}
		return null;
	}*/

	@Override
	public void registerUnreqBook(RegisterBookUnrequestedInputDto registerbook) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into 책 (book_title, call_number, publisher, author, book_intro, loan_possible, publication_year, name) values(?,?,?,?,?,?,?,?)";
		
		try{
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, registerbook.getTitle());
			ps.setString(2, registerbook.getBooknum());
			ps.setString(3, registerbook.getPublisher());
			ps.setString(4, registerbook.getAuthor());
			ps.setString(5, registerbook.getIntro());
			ps.setInt(6, registerbook.getloanposb());
			ps.setDate(7, (Date) registerbook.getPubyear());
			ps.setString(8, registerbook.getCartname());
			
			ps.executeQuery();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.DbClose(con, ps);
		}
	}

	@Override
	public void registerReqBook(RegisterBookRequestedInputDto registerbook) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into 책 (book_title, call_number, publisher, author, book_intro, loan_possible, publication_year, name) values(?,?,?,?,?,?,?,?)";
		
		try{
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, registerbook.getTitle());
			ps.setString(2, registerbook.getCallnum());
			ps.setString(3, registerbook.getPublisher());
			ps.setString(4, registerbook.getAuthor());
			ps.setString(5, registerbook.getIntro());
			ps.setInt(6, registerbook.getBookposb());
			ps.setDate(7, (Date) registerbook.getPubyear());
			ps.setString(8, registerbook.getCartname());
			
			ps.executeQuery();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.DbClose(con, ps);
		}
		
	}

	@Override
	public void updateBook(UpdateBookBySeqInputDto updatebook) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update 책 set book_title = ?, call_number = ?, publisher=?, author=?, publication_year=? where book_seq = ?";
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, updatebook.getTitle());
			ps.setString(2, updatebook.getBooknum());
			ps.setString(3, updatebook.getPublisher());
			ps.setString(4, updatebook.getAuthor());
			ps.setDate(5, (Date) updatebook.getPubyear());
			ps.setLong(6, updatebook.getBookseq());
			ps.executeQuery();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.DbClose(con, ps);
		}
	}

	@Override
	public void deleteBook(DeleteBookInputDto deletebook) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete from 책 where book_seq = ?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setLong(1, deletebook.getBookseq());
			ps.executeQuery();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.DbClose(con, ps);
		}
	}

	@Override
	public void requestBook(RequestBookInputDto requestbook) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql="insert into 도서추가요청 (request_date, request_status, addbook_title, addbook_author, publisher, user_seq) values (select sysdate from dual,'처리 중',?,?,?,?)";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, requestbook.getTitle());
			ps.setString(2, requestbook.getAuthor());
			ps.setString(3, requestbook.getPublisher());
			ps.setLong(4, requestbook.getUserseq());
			ps.executeQuery();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.DbClose(con, ps);
		}
	}

	@Override
	public ManageBookRequestOutputDto manageRequest(ManageBookRequestInputDto managebook) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ManageBookRequestOutputDto op = null;
		String sql = "update 도서추가요청 set request_status='처리완료' where addbook_title=? and publisher=? and addbook_author=? and user_seq=?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, managebook.getTitle());
			ps.setString(2, managebook.getPublisher());
			ps.setString(3, managebook.getAuthor());
			ps.setLong(4, managebook.getUserseq());
			rs= ps.executeQuery();
			
			if(rs.next()) {
				op = new ManageBookRequestOutputDto();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.DbClose(con, ps, rs);
		}
		return null;
	}
	/**
	 * 별점
	 */
	@Override
	public void rateBook(RateBookInputDto ratebook) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into 별점 (rating_date, score, book_seq, user_seq) values((select sysdate from dual), ?,?,?)";
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, ratebook.getScore());
			ps.setLong(2, ratebook.getBookseq());
			ps.setLong(3, ratebook.getUserseq());
			ps.executeQuery();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.DbClose(con, ps);
		}
		
	}
	
	@Override
	public List<ViewLoanHistoryOutputDto> viewLoan(ViewLoanHistoryInputDto loanbook) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ViewLoanHistoryOutputDto> loanlist = new ArrayList<>();
		String sql = "select book_title,call_number,publisher,author,publication_year,rental_date,expectedreturn_date from 대여 join 대여상세 using(borrow_seq) join 책 using(book_seq) where user_seq=?";
		try {
			con = DBUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setLong(1, loanbook.getUserseq());
			rs = ps.executeQuery();
			while(rs.next()) {
				ViewLoanHistoryOutputDto op = new ViewLoanHistoryOutputDto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getDate(6),rs.getDate(7));
				loanlist.add(op);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.DbClose(con, ps, rs);
		}
		
		return loanlist;
	}
	
	@Override
	public List<RecommendBookOutputDto> recommendBook(RecommendBookInputDto recommendbook) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<RecommendBookOutputDto> recommendlist = new ArrayList<>();
		String sql = "SELECT AVG(별점.score) AS average_score, 책.book_title, 책.call_number, 책.publisher, 책.author, 책.publication_year, 책.loan_possible\r\n"
				+ "FROM 별점, 책\r\n"
				+ "WHERE 별점.book_seq = 책.book_seq AND 책.name = (SELECT 회원.category FROM 회원 WHERE 회원.user_seq = ?)\r\n"
				+ "GROUP BY 책.book_seq, 책.book_title, 책.call_number, 책.publisher, 책.author, 책.publication_year, 책.loan_possible, 책.name\r\n"
				+ "ORDER BY AVG(별점.score) DESC\r\n"
				+ "FETCH FIRST 5 ROWS ONLY";
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setLong(1, recommendbook.getUserseq());	//sql문에 첫 번째 ? 안에 값을 넣어준다.
			rs = ps.executeQuery();
			while(rs.next()) {
				RecommendBookOutputDto op = new RecommendBookOutputDto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getInt(7));
				recommendlist.add(op);
				
			}
			return recommendlist;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.DbClose(con, ps, rs);
		}
		return null;
		
	}
	
	/**
	 * 도서 대여
	 */
	@Override
	public CheckBookAvailabilityBySeqOutputDto checkBook(CheckBookAvailabilityBySeqInputDto checkbook) {
		Connection con = null;
		PreparedStatement psInsert = null;
		PreparedStatement psUpdate = null;
		ResultSet rs = null;
		CheckBookAvailabilityBySeqOutputDto checkbookdto = new CheckBookAvailabilityBySeqOutputDto();
		String insertsql = "insert into 대여 (Rental_Date, user_seq)VALUES((select sysdate from dual),?)";
		String updatesql = "update 책 set loan_possible = loan_possible - 1 where loan_possible = 1 and book_seq = ?";
		
		try {
			con = DBUtil.getConnection();
			psInsert = con.prepareStatement(insertsql);
			psInsert.setLong(1, checkbook.getUserseq());
			psInsert.executeUpdate();
			
			psUpdate = con.prepareStatement(updatesql);
			psUpdate.setLong(1, checkbook.getBookseq());
			
			rs= psUpdate.executeQuery();
			
			if(rs.next()) {
				checkbookdto = new CheckBookAvailabilityBySeqOutputDto();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.DbClose(con, psInsert, null);
			DBUtil.DbClose(null, psUpdate, rs);
		}
		return checkbookdto;
	}
		
	/**
	 * 도서 반납
	 */
	public ReturnBookBySeqOutputDto returnBook(ReturnBookBySeqInputDto returnbook) {
		Connection con = null;
		PreparedStatement psUpdate = null;
		PreparedStatement psDelete = null;
		ResultSet rs = null;
		ReturnBookBySeqOutputDto returnbookdto = new ReturnBookBySeqOutputDto();
		String updatesql = "update 책 set loan_possible = loan_possible + 1 where loan_possible = 0 and book_seq = ?";
		String deletesql = "delete from 대여 where user_seq = ?"; //borrow_seq = ? and 
		
		try {
			con = DBUtil.getConnection();
			psUpdate = con.prepareStatement(updatesql);
			psUpdate.setLong(1, returnbook.getBookseq());
			psUpdate.executeUpdate();
			
			psDelete = con.prepareStatement(deletesql);
			//psDelete.setLong(1, returnbook.);
			psDelete.setLong(1, returnbook.getUserseq());
			rs = psDelete.executeQuery();	
			
			if(rs.next()) {
				returnbookdto = new ReturnBookBySeqOutputDto();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.DbClose(con, psUpdate, null);
			DBUtil.DbClose(null, psDelete, rs);
		}
		return returnbookdto;
		
	}
	
	
}
