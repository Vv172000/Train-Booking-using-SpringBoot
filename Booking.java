package com.railway.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	int id;
	private	String passengerName;
	private String mobileNumber;
	private int age;
	private int noOfSeats;
	@ManyToOne
	@JoinColumn(name="train_id")
	Train train;



	public Booking(String passengerName, String mobileNumber, int age, int noOfSeats) {
		super();
		
		this.passengerName = passengerName;
		this.mobileNumber = mobileNumber;
		this.age = age;
		this.noOfSeats = noOfSeats;
		
	}



	public Booking() {
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getPassengerName() {
		return passengerName;
	}



	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}



	public String getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public int getNoOfSeats() {
		return noOfSeats;
	}



	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}



	public Train getTrain() {
		return train;
	}



	public void setTrain(Train train) {
		this.train = train;
	}

	}


