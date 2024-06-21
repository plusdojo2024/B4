package model;
import java.io.Serializable;

public class Tasks  implements Serializable {
	private int id;
	private String user_id;
	private int task_id;
	private String task;
	private int time;
	private boolean show;
	private String created_at;
	private String updated_at;


	public Tasks(int id , String user_id , String task , int time , boolean show , String created_at ,String updated_at) {
		this.id = id;
		this.user_id = user_id;
		this.task = task;
		this.time = time;
		this.show = show;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public Tasks(int id , String user_id , int task_id , int time , boolean show , String created_at ,String updated_at) {
		this.id = id;
		this.user_id = user_id;
		this.task_id = task_id;
		this.time = time;
		this.show = show;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public Tasks(int id , String user_id , int task_id ,String task, int time , boolean show , String created_at ,String updated_at) {
		this.id = id;
		this.user_id = user_id;
		this.task_id = task_id;
		this.task = task;
		this.time = time;
		this.show = show;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public Tasks() {
		this.id = 0;
		this.user_id = "";
		this.task_id = 0;
		this.task = "";
		this.time = 0;
		this.show = false;
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
	public void setTask_Id(int task_id) {
		this.task_id = task_id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}

	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}

	public boolean getShow() {
		return show;
	}
	public void setShow(boolean show) {
		this.show = show;
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
