package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import jakarta.servlet.http.HttpSession;
import model.beans.Match;
import model.beans.MatchDisplayer;
import model.beans.User;
import model.dao.DaoException;
import model.dao.DaoFactoryJdbc;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/stalk")
public class Stalk extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stringId = request.getParameter("id");
		if (stringId == null) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/stalk.jsp").forward(request, response);
			return;
		}
		int id = Integer.parseInt(stringId);
		System.out.println(id);

		var daoFactory = new DaoFactoryJdbc();
		var userDao = daoFactory.getUserDao();
		try {
			Optional<User> result = userDao.getAll().stream()
				.filter(e -> e.getId() == id)
				.findFirst();

			if (result.isEmpty()) {
				request.setAttribute("error", "No user of such id to stalk");
			} else {
				request.setAttribute("stalked", result.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/stalk.jsp").forward(request, response);
	}
}
