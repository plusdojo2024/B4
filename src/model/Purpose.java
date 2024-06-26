package model;

public class Purpose {
	private int id;
	private String user_id;
	private String arrival;
	private String destination;
	private String created_at;
	private String updated_at;

	public Purpose(int id , String user_id , String arrival , String destination ,String created_at ,String updated_at) {
		this.id = id;
		this.user_id = user_id;
		this.arrival = arrival;
		this.destination = destination;
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
	public void setUser_Id(String user_id) {
		this.user_id = user_id;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
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
