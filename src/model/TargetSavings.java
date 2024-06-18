package model;

import java.io.Serializable;

public class TargetSavings implements Serializable{
	private int id;
	private String user_id;
	private double target_saving;
	private String saving_period;
	private Boolean now;
	private String created_at;
	private String update_at;

	public TargetSavings() {
	}
	public TargetSavings(int number, String user_id, double target_saving, String saving_period, Boolean now,
						  String created_at, String update_at) {
		super();
		this.id = number;
		this.user_id = user_id;
		this.target_saving = target_saving;
		this.saving_period = saving_period;
		this.now = now;
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
	public double getTarget_saving() {
		return target_saving;
	}
	public void setTarget_saving(double target_saving) {
		this.target_saving = target_saving;
	}
	public String getSaving_period() {
		return saving_period;
	}
	public void setSaving_period(String saving_period) {
		this.saving_period = saving_period;
	}
	public Boolean getNow() {
		return now;
	}
	public void setNow(Boolean now) {
		this.now = now;
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
