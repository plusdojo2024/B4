package model;

import java.io.Serializable;

public class CurrentSavings implements Serializable{
	private int id;
	private String user_id;
	private int current_saving;
	private String created_at;
	private String updated_at;


	public CurrentSavings (int number, String user_id, int current_saving,
			String created_at, String updated_at) {
		this.id = number;
		this.user_id = user_id;
		this.current_saving = current_saving;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public CurrentSavings() {
		this.id = 0;
		this.user_id = "";
		this.current_saving = 0;
		this.created_at = null;
		this.updated_at = null;
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
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
}