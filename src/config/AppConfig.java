package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import book.dao.BookDAO;
import book.dao.BookDAOImpl;
import book.service.BookService;
import book.service.impl.BookServiceImpl;
import member.dao.MemberDAO;
import member.dao.MemberDAOImpl;
import member.service.MemberService;
import member.service.MemberServiceImpl;

public class AppConfig {
	private static AppConfig instance = new AppConfig();
	private final BookService bookService;
	private final BookDAO bookDAO;

	private final MemberService memberService;
	private final MemberDAO memberDAO;;

	public AppConfig() {
		bookDAO = new BookDAOImpl();
		bookService = new BookServiceImpl(bookDAO);
		memberDAO = new MemberDAOImpl();
		memberService = new MemberServiceImpl(memberDAO);
	}

	public static AppConfig getInstance() {
		return instance;
	}

	public BookService getBookService() {
		return bookService;
	}

	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public MemberDAO getMemberDAO() {
		return memberDAO;
	}

	public class DBUtil {

		public interface DbProperties {
			public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
			String URL = "jdbc:oracle:thin:@192.168.0.28:1521:xe";
			String USER_ID = "c##library_member";
			String USER_PASS = "1234";
		}

		static {
			try {
				Class.forName(DbProperties.DRIVER_NAME);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		public static Connection getConnection() throws SQLException {
			return DriverManager.getConnection(DbProperties.URL, DbProperties.USER_ID, DbProperties.USER_PASS);
		}

		public static void DbClose(Connection con, Statement st) {
			try {
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public static void DbClose(Connection con, Statement st, ResultSet rs) {
			try {
				if (rs != null)
					rs.close();
				DbClose(con, st);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
