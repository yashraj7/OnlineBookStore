package in.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.code.dao.UserDaoImpl;
import in.code.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		if ("admin@gmail.com".equalsIgnoreCase(email) && "admin".equals(password)) {
			User us = new User();
			us.setName("Admin");
			session.setAttribute("userObj", us);
			resp.sendRedirect("admin/home.jsp");
		} else {
			UserDaoImpl dao = new UserDaoImpl();
			User us = dao.login(email, password);
			if (us != null) {
				session.setAttribute("userObj", us);
				resp.sendRedirect("index.jsp");

			} else {
				session.setAttribute("failMsg", "Email and Password Invalid");
				resp.sendRedirect("login.jsp");
			}
		}

	}

}
