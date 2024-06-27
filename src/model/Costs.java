package model;
// test
import java.io.Serializable;

public class Costs implements Serializable{
	private int id;
	private String user_id;
	private String fixed_id;
	private int fixed_money;
	private String created_at;
	private String updated_at;


	public Costs(int number,String user_id, String fixed_id, int fixed_money,
			String created_at, String updated_at) {
		this.id = number;
		this.user_id = user_id;
		this.fixed_id = fixed_id;
		this.fixed_money = fixed_money;
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
	public String getFixed_id() {
		return fixed_id;
	}
	public void setFixed_id(String fixed_id) {
		this.fixed_id = fixed_id;
	}
	public int getFixed_money() {
		return fixed_money;
	}
	public void setFixed_money(int fixed_money) {
		this.fixed_money = fixed_money;
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
