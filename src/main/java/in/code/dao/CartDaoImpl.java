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
import in.code.entity.Cart;

public class CartDaoImpl implements ICartDao {
	private Connection con;
	private PreparedStatement ps;

	public String addCart(Cart c) {
		String status = "";
		try {
			String sql = "insert into cart(bid,uid,bookName,author,price,total_price,category) values (?,?,?,?,?,?,?)";
			con = JdbcUtil.getJdbcConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, c.getBid());
			ps.setInt(2, c.getUserId());
			ps.setString(3, c.getBookName());
			ps.setString(4, c.getAuthor());
			ps.setDouble(5, c.getPrice());
			ps.setDouble(6, c.getTotalPrice());
			ps.setString(7, c.getCategory());
			int rowUpdated = ps.executeUpdate();

			if (rowUpdated == 1)
				status = c.getCategory();
			else
				status = "fail";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<Cart> getBookByUser(int userId) {
		List<Cart> list = new ArrayList<Cart>();
		Cart c = null;
		double totalPrice = 0;
		try {
			con = JdbcUtil.getJdbcConnection();
			String sql = "select * from Cart where uid = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new Cart();
				c.setCid(rs.getInt(1));
				c.setBid(rs.getInt(2));
				c.setUserId(rs.getInt(3));
				c.setBookName(rs.getString(4));
				c.setAuthor(rs.getString(5));
				c.setPrice(rs.getDouble(6));
				c.setCategory(rs.getString(8));

				totalPrice += rs.getDouble(7);
				c.setTotalPrice(totalPrice);
				list.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteBook(int bid, int cid, int uid) {
		boolean f = false;
		try {
			con = JdbcUtil.getJdbcConnection();
			String sql = "delete from cart where bid = ? and cid = ? and uid = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, bid);
			ps.setInt(2, cid);
			ps.setInt(3, uid);
			int rowUpdated = ps.executeUpdate();
			if (rowUpdated >= 1)
				f = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return f;
	}

}
