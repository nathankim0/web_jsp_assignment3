package kpu.book.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kpu.book.domain.BookVO;

public class BookDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost/jspdb?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "jspbook", "passwd");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	void disconnect() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}	
	public boolean add(BookVO vo) {
		connect();
		String sql = "insert into book values (?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBookNo());
			pstmt.setString(2, vo.getBookName());
			pstmt.setString(3, vo.getAuthor());
			pstmt.setString(4, vo.getIsCheck());
			pstmt.setString(5, vo.getCheckDay());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}
	public boolean update(BookVO vo) {
		connect();
		String sql = "update book set bookname=?, author=?, ischeck=?, checkDay=?" + "where bookNo=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBookName());
			pstmt.setString(2, vo.getAuthor());
			pstmt.setString(3, vo.getIsCheck());
			pstmt.setString(4, vo.getCheckDay());
			pstmt.setString(5, vo.getBookNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}
	
	public boolean delete(BookVO vo) {
		connect();
		String sql = "delete from book where bookNo=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBookNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}
	public boolean addMemo(BookVO vo) {
		connect();
		String sql = "insert into book_memo value(?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMemo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}
	public boolean memDelete(BookVO vo) {
		connect();
		String sql = "delete from book_memo where mem=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMemo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}
	public ArrayList<BookVO> getBookList() {
		connect();
		ArrayList<BookVO> booklist = new ArrayList<BookVO>();
		String sql = "select * from book ";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BookVO vo = new BookVO();
				vo.setBookNo(rs.getString("bookNo"));
				vo.setBookName(rs.getString("bookname"));
				vo.setAuthor(rs.getString("author"));
				vo.setIsCheck(rs.getString("ischeck"));
				vo.setCheckDay(rs.getString("checkDay"));
				booklist.add(vo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return booklist;
	}
	public ArrayList<BookVO> getMemoList() {
		connect();
		ArrayList<BookVO> memoList = new ArrayList<BookVO>();
		String sql = "select * from book_memo ";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BookVO vo = new BookVO();
				vo.setMemo(rs.getString("mem"));

				memoList.add(vo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return memoList;
	}
	public BookVO read(String ID) {
		connect();
		String sql = "select * from book where bookNo=?";
    	BookVO vo = null;

	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, ID);
	        
	        ResultSet result = pstmt.executeQuery();

	        while (result.next()) {
	        	vo = new BookVO();
				vo.setBookNo(result.getString("bookNo"));
				vo.setBookName(result.getString("bookname"));
				vo.setAuthor(result.getString("author"));
				vo.setIsCheck(result.getString("ischeck"));
				vo.setCheckDay(result.getString("checkDay"));
	        }
	        result.close();        
	    }
	    catch(Exception e) {
	        e.printStackTrace();
	    }
	    finally {
			disconnect();
	    }
	    return vo;
	}
}
