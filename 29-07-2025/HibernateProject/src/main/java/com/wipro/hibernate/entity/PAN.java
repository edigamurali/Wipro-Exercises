package com.wipro.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pan_details")
public class PAN {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;	
	@Column(name="name")
	String panholderName;	
	@Column(name="number")
	String panNumber;
	
	
	public PAN() {
		super();
	}
	
	
	public PAN(int id,String panNumber,String panholderName) {
		super();
		this.id = id;
		this.panholderName = panholderName;
		this.panNumber = panNumber;
	}


	public PAN(String panNumber,String panholderName) {
		super();
		this.panholderName = panholderName;
		this.panNumber = panNumber;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPanholderName() {
		return panholderName;
	}


	public void setPanholderName(String panholderName) {
		this.panholderName = panholderName;
	}


	public String getPanNumber() {
		return panNumber;
	}


	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}


	@Override
	public String toString() {
		return "PAN [id=" + id + ", panholderName=" + panholderName + ", panNumber=" + panNumber + "]";
	}
	

	
}
