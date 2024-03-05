package book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import book.dto.Book;
import book.dto.BookDto.SearchBookByTitleInputDto;
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
		String sql = "select * from 책 where book_title like ?";
		
		try { 
			con = AppConfig.DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1,searchbook.getTitle());
			
			rs = ps.executeQuery();
				
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.DbClose(con, ps, rs);
		}
		
		return booklist;
	}
	
}
