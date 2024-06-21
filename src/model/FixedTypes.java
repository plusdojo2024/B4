package model;

import java.io.Serializable;

public class FixedTypes implements Serializable {
	private int id;
	private String fixed;
	private String created_at;
	private String updated_at;


	public FixedTypes (int number, String fixed,
			String created_at, String updated_at) {
		this.id = number;
		this.fixed = fixed;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public FixedTypes() {
		this.id = 0;
		this.fixed = null;
		this.created_at = null;
		this.updated_at = null;
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
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
}
