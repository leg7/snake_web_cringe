package model.beans;

public class User {
	private int id;
	private String nick;
	private String email;
	private String password;

	private User() {
	}

	public static User nullUser() {
		User user = new User();
		user.id = 0;
		user.nick = user.email = user.password = "";

		return user;
	}

	public static User userToInsert(String nick, String email, String password) {
		User user = new User();
		user.nick = nick;
		user.email = email;
		user.password = password;
		user.id = -1;

		return user;
	}

	public static User userInDB(int id, String nick, String email, String password) {
		User user = User.userToInsert(nick, email, password);
		user.id = id;

		return user;
	}

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String username) {
		this.nick = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

