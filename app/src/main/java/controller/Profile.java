package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

@WebServlet("/profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var session = request.getSession();
		User loggedInUser = (User)session.getAttribute("user");
		if (loggedInUser == null) {
			return;
		}
		var daoFactory = new DaoFactoryJdbc();
		var matchDao = daoFactory.getMatchDao();

		// var match1 = new Match(1, 2);
		// var match2 = new Match(1, 3);
		// var match3 = new Match(2, 3);
		// var match4 = new Match(3, 2);

		try {
			// matchDao.create(match1);
			// matchDao.create(match2);
			// matchDao.create(match3);
			// matchDao.create(match4);
			List<Match> matches = matchDao.getAll();
			List<MatchDisplayer> matchDisplayers = new ArrayList<MatchDisplayer>();
			for (var match : matches) {
				boolean won;
				int opponent_id;
				if (match.getWinner_id() == loggedInUser.getId()) {
					won = true;
					opponent_id = match.getLoser_id();
					matchDisplayers.add(new MatchDisplayer(opponent_id, won));
				} else if (match.getLoser_id() == loggedInUser.getId()) {
					won = false;
					opponent_id = match.getWinner_id();
					matchDisplayers.add(new MatchDisplayer(opponent_id, won));
				} else {
					continue;
				}
			}
			request.setAttribute("matchDisplayers", matchDisplayers);
		} catch (DaoException e) {
			request.setAttribute("error", e.getMessage());
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/profile.jsp").forward(request,response);
	}
}
