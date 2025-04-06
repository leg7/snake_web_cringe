package model.beans;

// On limite la taille des champs directement dans le form html de signup
// Donc pas besoin de lancer d'exceptions
public class User {
	private int id;
	private String nick;
	private String email;
	private String password;

	public User() {
		this.id = -1;
		this.nick = this.email = this.password = "";
	}

	public User(String nick, String email, String password) {
		this();
		this.nick = nick;
		this.email = email;
		this.password = password;
		this.id = -1;
	}

	public User(int id, String nick, String email, String password) {
		this(nick, email, password);
		this.id = id;
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

