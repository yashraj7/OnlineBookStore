package in.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.code.dao.BookDaoImpl;

@WebServlet("/delete")
public class BooksDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			BookDaoImpl dao = new BookDaoImpl();
			boolean msg = dao.deleteBooks(id);

			HttpSession session = req.getSession();
			if (msg) {
				session.setAttribute("succMsg", "Book Deleted SuccessFully ");
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
