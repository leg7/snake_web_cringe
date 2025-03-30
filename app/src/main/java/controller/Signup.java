package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.beans.User;
import model.dao.Dao;
import model.dao.DaoFactory;
import model.dao.DaoFactoryJdbc;
import model.dao.UserDaoJdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Signup() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var daoFactory = new DaoFactoryJdbc("jdbc:sqlite:database.db");
		var userDao = daoFactory.getUserDao();

		var nick = request.getParameter("nick");
		request.setAttribute("nick", nick);

		var email = request.getParameter("email");

		var password = request.getParameter("password");
		request.setAttribute("password", password);

		var user = User.userToInsert(nick, email, password);
		userDao.create(user);

		var userList = userDao.getAll();
		request.setAttribute("userList", userList);

		// HttpSession session = request.getSession();

		this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
	}
}

