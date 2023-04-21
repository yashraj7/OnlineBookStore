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

@WebServlet("/remove_book")
public class RemoveBookCart extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bid = Integer.parseInt(req.getParameter("bid"));
		int cid = Integer.parseInt(req.getParameter("cid"));
		int uid = Integer.parseInt(req.getParameter("uid"));
		
		CartDaoImpl dao = new CartDaoImpl();
		boolean status = dao.deleteBook(bid,cid,uid);
		HttpSession session = req.getSession();
		if(status)
		{
			session.setAttribute("succMsg", "Book Removed from Cart");
			resp.sendRedirect("checkout.jsp");
		}
		else
		{
			session.setAttribute("failed", "Something went wrong with server");
			resp.sendRedirect("checkout.jsp");
		}
	}

}
