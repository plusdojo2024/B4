package model;

import java.io.Serializable;

public class FixedTypes implements Serializable {
	private int id;
	private String fixed;
	private String created_at;
	private String update_at;

	public FixedTypes() {
	}
	public FixedTypes (int number, String fixed,
			String created_at, String update_at) {
		super();
		this.id = number;
		this.fixed = fixed;
		this.created_at = created_at;
		this.update_at = update_at;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFixed() {
		return fixed;
	}
	public void setFixed(String fixed) {
		this.fixed = fixed;
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
