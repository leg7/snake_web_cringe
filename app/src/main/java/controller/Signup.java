package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.beans.BeanException;
import model.beans.User;
import model.dao.DaoFactoryJdbc;

import java.io.IOException;

@WebServlet("/signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Signup() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("nick", "");
		request.setAttribute("email", "");
		request.setAttribute("password", "");

		this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var daoFactory = new DaoFactoryJdbc();
		var userDao = daoFactory.getUserDao();

		var nick = request.getParameter("nick");
		var email = request.getParameter("email");
		var password = request.getParameter("password");

		try {
			var newUser = User.userToInsert(nick, email, password);
			userDao.create(newUser);

			// to debug
			var userList = userDao.getAll();
			request.setAttribute("userList", userList);

			// For the signup-success message and to know if user is logged in
			var sesh = request.getSession();
			sesh.setAttribute("user", newUser);

			response.sendRedirect("/app/signup-success");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			request.setAttribute("nick", nick);
			request.setAttribute("email", email);
			request.setAttribute("password", password);
			this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
		}

	}
}

