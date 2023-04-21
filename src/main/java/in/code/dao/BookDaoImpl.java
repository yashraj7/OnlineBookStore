package in.code.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.code.db.JdbcUtil;
import in.code.entity.BookDetails;

public class BookDaoImpl implements IBookDao {
	private Connection con;
	private PreparedStatement ps;

	public boolean addBook(BookDetails b) {

		boolean flag = false;
		try {
			con = JdbcUtil.getJdbcConnection();
			ps = con.prepareStatement(
					"insert into book_details	(bookName,author,price,bookCategory,status,photo,email) values(?,?,?,?,?,?,?)");
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getAuthor());
			ps.setDouble(3, b.getPrice());
			ps.setString(4, b.getBookCategory());
			ps.setString(5, b.getStatus());
			ps.setString(6, b.getPhotoName());
			ps.setString(7, b.getEmail());
			int rowUpdated = ps.executeUpdate();
			if (rowUpdated == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return flag;
	}

	public List<BookDetails> getAllBooks() {
		List<BookDetails> list = new ArrayList<BookDetails>();
		BookDetails b = null;
		try {
			con = JdbcUtil.getJdbcConnection();
			String sql = "select * from book_details";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new BookDetails();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getDouble(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEmail(rs.getString(8));

				list.add(b);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public BookDetails getBookById(int id) {

		BookDetails b = null;
		try {
			con = JdbcUtil.getJdbcConnection();
			String sql = "select * from book_details where bookId = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				b = new BookDetails();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getDouble(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEmail(rs.getString(8));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean updateEditBooks(BookDetails b) {
		boolean f = false;
		try {
			con = JdbcUtil.getJdbcConnection();
			String sql = "update book_details set bookName= ? , author = ? , price = ? , status = ?  where bookId = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getAuthor());
			ps.setDouble(3, b.getPrice());
			ps.setString(4, b.getStatus());
			ps.setInt(5, b.getBookId());
			int rowUpdated = ps.executeUpdate();
			if (rowUpdated == 1)
				f = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean deleteBooks(int id) {
		boolean f = false;
		try {
			con = JdbcUtil.getJdbcConnection();
			String sql = "delete from book_details where bookId = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int rowUpdated = ps.executeUpdate();
			if (rowUpdated == 1)
				f = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<BookDetails> getNewBooks() {
		List<BookDetails> list = new ArrayList<BookDetails>();
		BookDetails b = null;
		String sql = "select * from book_details where bookCategory = ? and status = ? order by bookId desc ";
		try {
			con = JdbcUtil.getJdbcConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "New Book");
			ps.setString(2, "Active");
			int i = 1;
			ResultSet rs = ps.executeQuery();
			while (rs.next() && i <= 4) {
				b = new BookDetails();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getDouble(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEmail(rs.getString(8));

				list.add(b);
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<BookDetails> getOldBooks() {
		List<BookDetails> list = new ArrayList<BookDetails>();
		BookDetails b = null;
		String sql = "select * from book_details where bookCategory = ? and status = ? order by bookId desc ";
		try {
			con = JdbcUtil.getJdbcConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "Old Book");
			ps.setString(2, "Active");
			int i = 1;
			ResultSet rs = ps.executeQuery();
			while (rs.next() && i <= 4) {
				b = new BookDetails();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getDouble(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEmail(rs.getString(8));

				list.add(b);
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<BookDetails> getAllNewBooks() {
		List<BookDetails> list = new ArrayList<BookDetails>();
		BookDetails b = null;
		String sql = "select * from book_details where bookCategory = ? and status = ? order by bookId desc ";
		try {
			con = JdbcUtil.getJdbcConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "New Book");
			ps.setString(2, "Active");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new BookDetails();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getDouble(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEmail(rs.getString(8));

				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<BookDetails> getAllOldBooks() {
		List<BookDetails> list = new ArrayList<BookDetails>();
		BookDetails b = null;
		String sql = "select * from book_details where bookCategory = ? and status = ? order by bookId desc ";
		try {
			con = JdbcUtil.getJdbcConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "Old Book");
			ps.setString(2, "Active");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new BookDetails();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getDouble(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEmail(rs.getString(8));

				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<BookDetails> getBooksBySearch(String ch) {
		List<BookDetails> list = new ArrayList<BookDetails>();
		BookDetails b = null;
		String sql = "select * from book_details where bookName like ? or author like ? or bookCategory like ? and status = ?";
		try {
			con = JdbcUtil.getJdbcConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + ch + "%");
			ps.setString(2, "%" + ch + "%");
			ps.setString(3, "%" + ch + "%");
			ps.setString(4, "Active");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new BookDetails();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getDouble(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setEmail(rs.getString(8));

				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

}
