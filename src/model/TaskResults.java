package model;
import java.io.Serializable;

public class TaskResults  implements Serializable {
	private int id;
	private String user_id;
	private int task_id;
	private int execution;
	private String created_at;
	private String updated_at;

	public TaskResults(int id , String user_id , int task_id , int execution , String created_at , String updated_at) {
		this.id = id;
		this.user_id = user_id;
		this.task_id = task_id;
		this.execution = execution;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public TaskResults() {
		this.id = 0;
		this.user_id = "";
		this.task_id = 0;
		this.execution = 0;
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
	public void setUser_Id(String user_id) {
		this.user_id = user_id;
	}

	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public int getExecution() {
		return execution;
	}
	public void setExecution(int execution) {
		this.execution = execution;
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
