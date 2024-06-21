package model;

import java.io.Serializable;

public class Incomes implements Serializable {
	private int id;
	private String user_id;
	private int income;
	private String created_at;
	private String updated_at;

	public Incomes(int number, String user_id, int income,
			String created_at, String updated_at) {
		this.id = number;
		this.user_id = user_id;
		this.income = income;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public Incomes() {
		this.id = 0;
		this.user_id = "";
		this.income = 0;
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
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
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
