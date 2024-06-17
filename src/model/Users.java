package model;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Users implements Serializable {
	private int id;
	private String user_id;	// ID
	private String password;
	private String user_name;
	private String address;// PW
	private int birth_day;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;

	public Users() {

	}

	public Users(int number, String user_id, String password, String user_name, String address, int birth_day,
			LocalDateTime created_at,LocalDateTime updated_at) {
		super();
		this.id = number;
		this.user_id = user_id;
		this.password = password;
		this.user_name = user_name;
		this.address = address;
		this.birth_day = birth_day;
		this.address = address;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String addres) {
		this.address = addres;
	}
	public int getBirth_day() {
		return birth_day;
	}
	public void setBirth_day(int birth_day) {
		this.birth_day = birth_day;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}


}
