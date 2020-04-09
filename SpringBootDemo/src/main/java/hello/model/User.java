package hello.model;

public class User {
	private int id;
	private String username;
	private String password;
	private String email;

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public User(String username, String pass) {
		setUsername(username);
		setPassword(pass);
		setEmail("");
		
	}
	
	public User(String username,String pass, String email) {
		setUsername(username);
		setPassword(pass);
		setEmail(email);
	}
	
	public User() {}
	
	
	public User(int id,String name,String pass,String mail) {
		this.id =id;
		username=name;
		password=pass;
		email=mail;
	}

}
