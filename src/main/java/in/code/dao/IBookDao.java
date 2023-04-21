package in.code.dao;

import java.util.List;

import in.code.entity.BookDetails;

public interface IBookDao {

	public boolean addBook(BookDetails b);

	public List<BookDetails> getAllBooks();

	public BookDetails getBookById(int id);

	public boolean updateEditBooks(BookDetails b);

	public boolean deleteBooks(int id);

	public List<BookDetails> getNewBooks();

	public List<BookDetails> getOldBooks();

	public List<BookDetails> getAllNewBooks();

	public List<BookDetails> getAllOldBooks();
	
	public List<BookDetails> getBooksBySearch(String ch);

}
