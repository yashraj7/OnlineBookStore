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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("fname");
		String email = req.getParameter("email");
		String phno = req.getParameter("phno");
		String password = req.getParameter("password");
		String check = req.getParameter("check");

		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhno(phno);
		HttpSession session = req.getSession();
		if (check != null) {
			UserDaoImpl userDao = new UserDaoImpl();
			boolean usercheck = userDao.checkUser(email);
			if (!usercheck) {
				boolean status = userDao.userRegister(user);
				System.out.println(status);
				if (status) {
					session.setAttribute("successMsg", "Registration Successfull");
					resp.sendRedirect("register.jsp");
				} else {
					session.setAttribute("failMsg", "Registration Unsuccessfull");
					resp.sendRedirect("register.jsp");
				}
			} else {
				session.setAttribute("failMsg", "User Already Exist Try another Email");
				resp.sendRedirect("register.jsp");
			}

		} else {
			session.setAttribute("failMsg", "Please Agree terms and conditions");
			resp.sendRedirect("register.jsp");
		}
	}

}
