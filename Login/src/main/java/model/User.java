package model;

public class User 
{
	String fName, lName, username, password;
	private static int idSeed=1;
	private final int id;
	
	public User(String fName, String lName, String username, String password)
	{
		id = idSeed++;
		this.fName = fName;
		this.lName = lName;
		this.username = username;
		this.password = password;
	}
	
	public String getFirstName() {
		return fName;
	}
	public void setFirstName(String fName) {
		this.fName = fName;
	}
	public String getLastName() {
		return lName;
	}
	public void setLastName(String lName) {
		this.lName = lName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId()
	{
		return id;
	}
}
