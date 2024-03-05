package book.dao;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.AppConfig;
import config.AppConfig.DBUtil;

public class BookDAOImpl implements BookDAO{
	
	public List<Book> SearchBook() throws SQLException{
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
				Book book = new Book(rs.getLong(1),rs.getString(2),rs.getInt(3),
						rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getInt(7),rs.getDate(8),rs.getString(9));
				booklist.add(book);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.DbClose(con, st, rs);
		}
	}
}
