package model;
import java.io.Serializable;

public class Users implements Serializable {
	private int id;
	private String user_id;	// ID
	private String password;
	private String user_name;
	private String addres;// PW
	private int birth_day;
	private datetime created_at;


	public Users(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public Users() {
		this.id = "";
		this.pw = "";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
}
