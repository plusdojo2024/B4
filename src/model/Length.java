package model;

import java.io.Serializable;

public class Length implements Serializable{
	private double target_savings;
	private String length;

	public Length(double target_savings, String length) {
		this.target_savings = target_savings;
		this.length = length;
	}
	public Length() {
		this.target_savings = 0;
		this.length = null;
	}
	public double getTarget_savings() {
		return target_savings;
	}
	public void setTarget_savings(double target_savings) {
		this.target_savings = target_savings;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
}
