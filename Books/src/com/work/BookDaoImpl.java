package com.work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao{
	public static String url = "jdbc:mysql://localhost:3306/books";
	public static String driverName = "com.mysql.cj.jdbc.Driver";
	public static String user = "root";
	public static String password = "root";
	public static ArrayList<Book> listBook;

	public Connection getDbConnection() {
		Connection con = null;
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to find the Driver");
		}
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("Unable to Connect with DB");
		}
		return con;

	}
	@Override
	public boolean insertBook(Book book) {
		Connection con = getDbConnection();
		
		if(con!=null) {
			String sql = "insert into book (title, author, price) VALUES (?, ?, ?)";
			PreparedStatement psmt;
			try {
				psmt = con.prepareStatement(sql);
				psmt.setString(1, book.getTitle());
				psmt.setString(2, book.getAuthor());
				psmt.setFloat(3, book.getPrice());
				int noofrowsAffected = psmt.executeUpdate();
				if (noofrowsAffected > 0) {
					 return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public List<Book> listAllBooks() {
		List<Book> listBook = new ArrayList<>();
		Connection connection = getDbConnection();
		String sql = "select * from book";
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				
				int id = rs.getInt("book_id");
	            String title = rs.getString("title");
	            String author = rs.getString("author");
	            float price = rs.getFloat("price");
	            System.out.println("---"+id);
	            System.out.println("---"+title);
	            Book book = new Book(id, title, author, price);
	            listBook.add(book);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return listBook;
	}

	@Override
	public boolean deleteBook(Integer id) {
		boolean rowDeleted=false;
		Connection con=getDbConnection();
		String sql = "delete from book where book_id=?";
		try {
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setInt(1,id);
			int noofrowsAffected = psmt.executeUpdate();
			if (noofrowsAffected > 0) {
				 rowDeleted=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rowDeleted;
	}

	@Override
	public boolean updateBook(Book book) {
		Connection con=getDbConnection();
		 String sql = "update book SET title = ?, author = ?, price = ? where book_id = ?";
		 try {
				PreparedStatement psmt=con.prepareStatement(sql);
				psmt.setString(1,book.getTitle());
				psmt.setString(2, book.getAuthor());
				psmt.setFloat(3, book.getPrice());
				psmt.setInt(4, book.getId());
				int executeUpdate = psmt.executeUpdate();
				if(executeUpdate>0) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return false;
	}

	@Override
	public Book getBook(int id) {
		Book book=null;
		Connection con=getDbConnection();
		PreparedStatement psmt;
		try {
			psmt = con.prepareStatement("select * from book where book_id=?");
			psmt.setInt(1,id);
			ResultSet rs=psmt.executeQuery();
			while(rs.next()) {
				book = new Book();
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getFloat("price"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return book;
	}

}
