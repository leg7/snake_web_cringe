package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dao.DaoException;
import model.dao.DaoFactoryJdbc;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			response.sendRedirect("/");
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var daoFactory = new DaoFactoryJdbc();
		var userDao = daoFactory.getUserDao();

		var password = request.getParameter("password");
		var nick = request.getParameter("nick");

		boolean retry = true;
		try {
			var users = userDao.getAll();
			for (var user : users) {
				if (user.getPassword().equals(password) && user.getNick().equals(nick)) {
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					response.sendRedirect("/");
					retry = false;
				}
			}
		} catch (DaoException e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}

		if (retry) {
			request.setAttribute("error", "Username or password incorrect, could not login");
			this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}

}
