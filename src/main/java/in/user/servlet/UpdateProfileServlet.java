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

@WebServlet("/update_profile")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("fname");
			String email = req.getParameter("email");
			String phno = req.getParameter("phno");
			String password = req.getParameter("password");

			User us = new User();

			us.setId(id);
			us.setName(name);
			us.setEmail(email);
			us.setPhno(phno);

			UserDaoImpl dao = new UserDaoImpl();
			boolean status = dao.checkpassword(id, password);
			HttpSession session = req.getSession();
			if (status) {
				boolean msg = dao.updateProfile(us);
				if (msg) {
					session.setAttribute("succMsg", "Profile Updated Successfull");
					resp.sendRedirect("edit_profile.jsp");
				} else {
					session.setAttribute("failMsg", "Server error");
					resp.sendRedirect("edit_profile.jsp");
				}

			}
			else {
				session.setAttribute("failMsg", "Password Wrong");
				resp.sendRedirect("edit_profile.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
