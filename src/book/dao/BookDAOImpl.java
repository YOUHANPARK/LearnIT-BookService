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
import book.dto.BookDto.RegisterBookRequestedInputDto;
import book.dto.BookDto.RegisterBookUnrequestedInputDto;
import book.dto.BookDto.RequestBookInputDto;
import book.dto.BookDto.SearchBookByCategoryInputDto;
import book.dto.BookDto.SearchBookBySeqInputDto;
import book.dto.BookDto.SearchBookBySeqOutputDto;
import book.dto.BookDto.SearchBookByTitleInputDto;
import book.dto.BookDto.UpdateBookBySeqInputDto;
import book.dto.BookDto.ViewFavoriteBookInputDto;
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
		String sql = "select book_seq, book_title, call_number, publisher, "
				+ "author, loan_possible from 책 where book_title like ?";
		
		try { 
			con = AppConfig.DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			//System.out.println(searchbook.getTitle());
			ps.setString(1,"%"+searchbook.getTitle()+"%");
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
		String sql = "select book_seq, book_title, call_number, publisher, "
				+ "author, loan_possible select from 책 JOIN 카테고리"
				+ "using(book_seq) where name like ?";
		
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

	@Override
	public CheckBookAvailabilityBySeqOutputDto checkBook(CheckBookAvailabilityBySeqInputDto checkbook) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.DbClose(con, ps, rs);
		}
		return null;
	}

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

	//@Override
	/*
	public void requestBook(RequestBookInputDto requestbook) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql="insert into 도서추가요청 (request_date, request_status, addbook_title, addbook_author, publisher, user_seq) values (select sysdate from dual,?,?,?,?,?)";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setDate(1, );
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.DbClose(con, ps);
		}
	}
	*/
	
}
