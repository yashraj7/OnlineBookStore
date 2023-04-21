package in.admin.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.code.dao.BookDaoImpl;
import in.code.entity.BookDetails;

@WebServlet("/edit_books")
public class EditBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String bookName = req.getParameter("bname");
			String author = req.getParameter("author");
			Double price = Double.parseDouble(req.getParameter("price"));
			String status = req.getParameter("status");

			BookDetails b = new BookDetails();
			b.setBookId(id);
			b.setBookName(bookName);
			b.setAuthor(author);
			b.setPrice(price);
			b.setStatus(status);

			HttpSession session = req.getSession();
			BookDaoImpl dao = new BookDaoImpl();
			boolean msg = dao.updateEditBooks(b);
			if (msg) {
				session.setAttribute("succMsg", "Book Updated SuccessFully ");
				resp.sendRedirect("admin/all_books.jsp");
			} else {
				session.setAttribute("failMsg", "Book Can't be Updated");
				resp.sendRedirect("admin/all_books.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
