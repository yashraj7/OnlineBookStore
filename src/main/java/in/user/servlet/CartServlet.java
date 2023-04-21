
package in.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.code.dao.BookDaoImpl;
import in.code.dao.CartDaoImpl;
import in.code.entity.BookDetails;
import in.code.entity.Cart;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int bid = Integer.parseInt(req.getParameter("bid"));
			int uid = Integer.parseInt(req.getParameter("uid"));

			BookDaoImpl dao = new BookDaoImpl();
			BookDetails b = dao.getBookById(bid);

			Cart c = new Cart();

			c.setBid(bid);
			c.setUserId(uid);

			c.setBookName(b.getBookName());
			c.setAuthor(b.getAuthor());
			c.setPrice(b.getPrice());
			c.setTotalPrice(b.getPrice());
			c.setCategory(b.getBookCategory());
			CartDaoImpl cdao = new CartDaoImpl();

			String status = cdao.addCart(c);

			HttpSession session = req.getSession();
			if (status.equals("New Book")) {
				session.setAttribute("addCart", "Book Added to Cart");
				resp.sendRedirect("all_new_book.jsp");
			} 
			else if(status.equals("Old Book"))
			{
				session.setAttribute("addCart", "Book Added to Cart");
				resp.sendRedirect("all_old_book.jsp");
			}
			else {
				session.setAttribute("failMsg", "Something went wrong in server");
				resp.sendRedirect("all_new_book.jsp");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
