package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class AmountUseds implements Serializable {
	private int id;
	private String user_id;
	private int amount_used;
	private String created_at;
	private String updated_at;
	public AmountUseds (int number, String user_id, int amount_used,
		String created_at, String updated_at) {
		this.id = number;
		this.user_id = user_id;
		this.amount_used = amount_used;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public AmountUseds() {
		this.id = 0;
		this.user_id = "";
		this.amount_used = 0;
		this.created_at = null;
		this.updated_at = null;
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
	public Integer getAmount_used() {
		return amount_used;
	}
	public void setAmount_used(Integer amount_used) {
		this.amount_used = amount_used;
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