package view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.beans.User;

public class SignupFormHandler {
	private SignupFormHandler() {}

	private static String NICK = "nick";
	private static String EMAIL = "email";
	private static String PASSWORD = "password";

	private static boolean validEmail(String email) {
		return true;
	}

	public static User createUser(HttpServletRequest request) throws FormException {
		String nick = request.getParameter(NICK);
		String email = request.getParameter(EMAIL);
		String password = request.getParameter(PASSWORD);

		if (nick == null || nick.equals("")) {
			throw new FormException("L'utilisateur doit avoir un nick non vide");
		}

		if (email == null || email.equals("") || !validEmail(email)) {
			throw new FormException("Entrez en email valide");
		}

		if (password == null || password.length() < 8) {
			throw new FormException("Le mot de passe doit faire au moins 8 char");
		}

		return new User(nick, email, password);
	}
}
