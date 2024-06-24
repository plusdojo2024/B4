package model;

import java.io.Serializable;

public class DiseaseList implements Serializable {
	private int id;
	private String disease;  // 病気名
	private int disease_money;
	private double standard;
	private double rank;
	private String created_at;
	private String updated_at;

	// 引数がないコンストラクタ
	public  DiseaseList() {

	}

	// 引数があるコンストラクタ

	public DiseaseList(int id, String disease, int disease_money, double standard, double rank , String created_at, String updated_at) {
		super();
		this.id = id;
		this.disease = disease;
		this.disease_money = disease_money;
		this.standard = standard;
		this.rank = rank;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public int getDisease_money() {
		return disease_money;
	}

	public void setDisease_money(int disease_money) {
		this.disease_money = disease_money;
	}

	public double getStandard() {
		return standard;
	}

	public void setStandard(double standard) {
		this.standard = standard;
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

	public double getRank() {
		return rank;
	}

	public void setRank(double rank) {
		this.rank = rank;
	}
}

