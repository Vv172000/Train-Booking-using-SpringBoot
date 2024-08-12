package com.railway.controlller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.railway.model.Booking;
import com.railway.service.BookingService;

public class BookingController {
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/createBooking/{id}{totalSeats}")
	public String createBooking(@PathVariable int id,@RequestBody Booking  booking,@RequestParam int totalSeats)
	{
		return bookingService.createBooking(id,booking,totalSeats);
    }
	
	@DeleteMapping("/ticketCancel/{id}")
	public String ticketCancel(@PathVariable int id){
		
		return bookingService.ticketCancel(id);
	}
	
	@GetMapping("/getTrainDetails/{id}")
	public Booking getTrainDetails(@PathVariable int id) {
		return bookingService.getTrainDetails(id);
	}
	
	@GetMapping("/getTicketDetails/{id}")
	public ArrayList<Object> getTicketDetails(@PathVariable int id) {
		return bookingService.getTicketDetails(id);
	
	}
	}


