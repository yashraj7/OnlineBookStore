package in.admin.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import in.code.dao.BookDaoImpl;
import in.code.dao.IBookDao;
import in.code.entity.BookDetails;

@WebServlet("/add_books")
@MultipartConfig
public class BooksAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookName = req.getParameter("bname");
		String author = req.getParameter("author");
		Double price = Double.parseDouble(req.getParameter("price"));
		String categories = req.getParameter("categories");
		String status = req.getParameter("status");
		Part part = req.getPart("bimg");
		String fileName = part.getSubmittedFileName();
		BookDetails bd = new BookDetails(bookName, author, price, categories, status, fileName, "admin");
		HttpSession session = req.getSession();
		BookDaoImpl dao = new BookDaoImpl();
		boolean msg = dao.addBook(bd);
		if (msg) {
			String path = getServletContext().getRealPath("") + "book";
			System.out.println(path);
			File file = new File(path);
			part.write(path + File.separator + fileName);
			
			session.setAttribute("succMsg", "Book SuccessFully Added");
			resp.sendRedirect("admin/add_books.jsp");
		} else {
			session.setAttribute("failMsg", "Book Can't be Added");
			resp.sendRedirect("admin/add_books.jsp");
		}
	}

}
