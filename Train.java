package com.railway.model;

import java.time.LocalTime;
import java.util.List;

import com.railway.model.Booking;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Train")
public class Train {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private	int id;
private	String trainName;
private	String trainNo;
private	LocalTime arrivalTime;
private	LocalTime departureTime;
private	String destination;
private	String arrival;
private	int noOfSeats;
private	int price[]=new int[4];
@OneToMany(mappedBy ="train")
List<Booking>booking;



public Train() {
	super();
}



public Train(String trainName, String trainNo, LocalTime arrivalTime, LocalTime departureTime,
		String destination, String arrival, int noOfSeats, int[] price, List<Booking> booking) {
	super();
	this.trainName = trainName;
	this.trainNo = trainNo;
	this.arrivalTime = arrivalTime;
	this.departureTime = departureTime;
	this.destination = destination;
	this.arrival = arrival;
	this.noOfSeats = noOfSeats;
	this.price = price;
	this.booking = booking;
}



public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}



public String getTrainName() {
	return trainName;
}



public void setTrainName(String trainName) {
	this.trainName = trainName;
}



public String getTrainNo() {
	return trainNo;
}



public void setTrainNo(String trainNo) {
	this.trainNo = trainNo;
}



public LocalTime getArrivalTime() {
	return arrivalTime;
}



public void setArrivalTime(LocalTime arrivalTime) {
	this.arrivalTime = arrivalTime;
}



public LocalTime getDepartureTime() {
	return departureTime;
}



public void setDepartureTime(LocalTime departureTime) {
	this.departureTime = departureTime;
}



public String getDestination() {
	return destination;
}



public void setDestination(String destination) {
	this.destination = destination;
}



public String getArrival() {
	return arrival;
}



public void setArrival(String arrival) {
	this.arrival = arrival;
}



public int getNoOfSeats() {
	return noOfSeats;
}



public void setNoOfSeats(int noOfSeats) {
	this.noOfSeats = noOfSeats;
}



public int[] getPrice() {
	return price;
}



public void setPrice(int[] price) {
	this.price = price;
}



public List<Booking> getBooking() {
	return booking;
}



public void setBooking(List<Booking> booking) {
	this.booking = booking;
}



}
