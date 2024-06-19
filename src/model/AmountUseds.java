package model;

import java.io.Serializable;

public class AmountUseds implements Serializable {
	private int id;
	private String user_id;
	private int amount_used;
	private String created_at;
	private String update_at;

	public AmountUseds() {
	}
	public AmountUseds (int number, String user_id, int amount_used,
			String created_at, String update_at) {
		super();
		this.id = number;
		this.user_id = user_id;
		this.amount_used = amount_used;
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
	public int getAmount_used() {
		return amount_used;
	}
	public void setAmount_used(int amount_used) {
		this.amount_used = amount_used;
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