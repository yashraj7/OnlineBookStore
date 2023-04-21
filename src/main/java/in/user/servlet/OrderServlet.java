package in.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.code.dao.BookDaoImpl;
import in.code.dao.BookOrderDaoImpl;
import in.code.dao.CartDaoImpl;
import in.code.entity.Book_Order;
import in.code.entity.Cart;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name = req.getParameter("username");
			String email = req.getParameter("email");
			String phno = req.getParameter("phno");
			String address = req.getParameter("address");
			String landmark = req.getParameter("landmark");
			String city = req.getParameter("city");
			String state = req.getParameter("state");
			String pincode = req.getParameter("pincode");
			String paymentType = req.getParameter("payment");

			HttpSession session = req.getSession();
			int id = Integer.parseInt(req.getParameter("id"));

			String fullAddress = address + "," + landmark + "," + city + "," + state + "," + pincode;
			CartDaoImpl dao = new CartDaoImpl();
			List<Cart> blist = dao.getBookByUser(id);

			if (blist.isEmpty()) {
				session.setAttribute("failed", "Add Item");
				resp.sendRedirect("checkout.jsp");
				resp.sendRedirect("checkout.jsp");

			} else {
				BookOrderDaoImpl dao2 = new BookOrderDaoImpl();
				Book_Order o = null;

				ArrayList<Book_Order> orderList = new ArrayList<Book_Order>();

				Random r = new Random();
				for (Cart c : blist) {
					o = new Book_Order();
					o.setOrderId("BOOK-ORD-00" + r.nextInt(100));
					o.setUserName(name);
					o.setEmail(email);
					o.setPhno(phno);
					o.setFulladd(fullAddress);
					o.setBookName(c.getBookName());
					o.setAuthor(c.getAuthor());
					o.setPrice(c.getPrice() + "");
					o.setPaymentType(paymentType);
					orderList.add(o);
				}

				if ("noselect".equals(paymentType)) {
					session.setAttribute("failed", "please choose payment method");
					resp.sendRedirect("checkout.jsp");
				} else {
					boolean status = dao2.saveOrder(orderList);
					if (status) {
						resp.sendRedirect("order_success.jsp");
					} else {
						session.setAttribute("failed", "Order failed.");
						resp.sendRedirect("checkout.jsp");
					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
