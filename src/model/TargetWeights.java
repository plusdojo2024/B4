package model;

import java.io.Serializable;

public class TargetWeights implements Serializable  {
	private int id;
	private String user_id;
	private double target_weight;  // 目標体重
	private String exercise_period;
	private boolean now;
	private String created_at;
	private String updated_at;

	// 引数がないコンストラクタ
	public TargetWeights() {

	}

	// 引数があるコンストラクタ
	public TargetWeights(int id, String user_id, double target_weight, String exercise_period, boolean now,
			String created_at, String updated_at) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.target_weight = target_weight;
		this.exercise_period = exercise_period;
		this.now = now;
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

	public double getTarget_weight() {
		return target_weight;
	}

	public void setTarget_weight(double target_weight) {
		this.target_weight = target_weight;
	}

	public String getExercise_period() {
		return exercise_period;
	}

	public void setExercise_period(String exercise_period) {
		this.exercise_period = exercise_period;
	}

	public boolean isNow() {
		return now;
	}

	public void setNow(boolean now) {
		this.now = now;
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
