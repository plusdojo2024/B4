package model;
import java.io.Serializable;

public class TaskTypes  implements Serializable {
	private int id;
	private String task;
	private String created_at;
	private String updated_at;

	public TaskTypes(int id , String task , String created_at ,String updated_at) {
		this.id = id;
		this.task = task;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public TaskTypes() {
		this.id = 0;
		this.task = "";
		this.created_at = null;
		this.updated_at = null;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
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
