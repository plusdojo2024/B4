package model;

import java.io.Serializable;

public class Dates implements Serializable{
	private double target_weight;
	private String length;

	public Dates(double target_weight, String length) {
		super();
		this.target_weight = target_weight;
		this.length = length;
	}
	public Dates() {
		this.target_weight = 0;
		this.length = null;

	}
	public double getTarget_weight() {
		return target_weight;
	}
	public void setTarget_weight(double target_weight) {
		this.target_weight = target_weight;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
}


