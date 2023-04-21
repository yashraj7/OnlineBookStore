package in.code.dao;

import java.util.List;

import in.code.entity.Book_Order;

public interface IBookOrderDao {

	public boolean saveOrder(List<Book_Order> b);
	public List<Book_Order> getBook(String email);
	public List<Book_Order> getAllOrderedBook();
}
