package model;

import java.io.Serializable;

public class TargetSavings implements Serializable{
	private int id;
	private String user_id;
	private int target_saving;
	private int period;
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	private String saving_period;
	private String created_at;
	private String updated_at;

	public TargetSavings(int number, String user_id, int target_saving, int period,String saving_period,
			String created_at, String updated_at) {
		this.id = number;
		this.user_id = user_id;
		this.target_saving = target_saving;
		this.period = period;
		this.saving_period = saving_period;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public TargetSavings() {
		this.id = 0;
		this.user_id = "";
		this.target_saving = 0;
		this.saving_period = null;
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
	public int getTarget_saving() {
		return target_saving;
	}
	public void setTarget_saving(int target_saving) {
		this.target_saving = target_saving;
	}
	public String getSaving_period() {
		return saving_period;
	}
	public void setSaving_period(String saving_period) {
		this.saving_period = saving_period;
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
	public void setUpdate_at(String updated_at) {
		this.updated_at = updated_at;
	}
}
