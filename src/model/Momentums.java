package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Momentums implements Serializable{
	private int id;
	private  String  user_id;
	private double momentum;
	private String created_at;
	private String updated_at;

	// 引数がないコンストラクタ
	public Momentums() {

	}

	// 引数があるコンストラクタ
	public Momentums(int id, String user_id, double momentum, String created_at, String updated_at) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.momentum = momentum;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	   // タイムスタンプを解析するフォーマットを指定
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
    // LocalDateTimeオブジェクトに変換

	public int getYear() {
	    LocalDateTime dateTime = LocalDateTime.parse(getUpdated_at(), formatter);
		return  dateTime.getYear();
	}
	public int getMonth() {
		LocalDateTime dateTime = LocalDateTime.parse(getUpdated_at(), formatter);
		return dateTime.getMonthValue();
	}
	public int getDay() {
		LocalDateTime dateTime = LocalDateTime.parse(getUpdated_at(), formatter);
		return dateTime.getDayOfMonth();
	}
	public int getTime() {
		LocalDateTime dateTime = LocalDateTime.parse(getUpdated_at(), formatter);
		return dateTime.getHour();
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

	public double getMomentum() {
		return momentum;
	}

	public void setMomentum(double momentum) {
		this.momentum = momentum;
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


