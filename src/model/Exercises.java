package model;

import java.io.Serializable;

public class Exercises implements Serializable {
	private int id;
	private double mets;  // 運動強度
	private String exercise_name;
	private String created_at;
	private String updated_at;

	//	引数がないコンストラクタ
	public Exercises() {

	}

	//	引数があるコンストラクタ
	public Exercises(int id, double mets, String exercise_name, String created_at, String updated_at) {
		super();
		this.id = id;
		this.mets = mets;
		this.exercise_name = exercise_name;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getMets() {
		return mets;
	}
	public void setMets(double mets) {
		this.mets = mets;
	}
	public String getExercise_name() {
		return exercise_name;
	}
	public void setExercise_name(String exercise_name) {
		this.exercise_name = exercise_name;
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
