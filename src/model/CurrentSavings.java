package model;

import java.io.Serializable;

public class CurrentSavings implements Serializable{
	private int id;
	private String user_id;
	private int current_saving;
	private String created_at;
	private String update_at;

	public CurrentSavings() {
	}
	public CurrentSavings (int number, String user_id, int current_saving,
			String created_at, String update_at) {
		super();
		this.id = number;
		this.user_id = user_id;
		this.current_saving = current_saving;
		this.created_at = created_at;
		this.update_at = update_at;
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
	public int getCurrent_saving() {
		return current_saving;
	}
	public void setCurrent_saving(int current_saving) {
		this.current_saving = current_saving;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdate_at() {
		return update_at;
	}
	public void setUpdate_at(String update_at) {
		this.update_at = update_at;
	}
}