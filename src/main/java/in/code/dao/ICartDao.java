package in.code.dao;

import java.util.List;

import in.code.entity.Cart;

public interface ICartDao {
	public String addCart(Cart c);
	public List<Cart> getBookByUser(int userId);
	public boolean deleteBook(int bid , int cid , int uid);
}
