package com.railway.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.railway.model.Booking;
import com.railway.model.Train;
import com.railway.respo.BookingRepository;
import com.railway.respo.TrainRepository;

public class BookingService {
	
	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	TrainRepository trainRepository;
	
	
	public String createBooking(int id, Booking booking, int totalSeats)  {
		Optional<Train> optionalTrain = trainRepository.findById(id);
		if (optionalTrain.isPresent()) {
			Train train = optionalTrain.get();
			int dbSeats = train.getNoOfSeats();
			if (totalSeats <= dbSeats) {
				dbSeats = dbSeats - totalSeats;
				train.setNoOfSeats(dbSeats);
				trainRepository.save(train);
		        booking.setNoOfSeats(totalSeats);
		        booking.setTrain(train);
				bookingRepository.save(booking);
			} else {
				return ("Seats not available");
			}
		}
		else {
			return ("Train not found with id: " + id); }
		
		return ("your "+totalSeats+" are booking successfull");
	}

	public String ticketCancel(int id) {
		
		Optional<Booking> bookingOptional=bookingRepository.findById(id);
		if(bookingOptional.isPresent()) {
			bookingRepository.deleteById(id);
		Booking booking=	bookingOptional.get();
		int dbSeatsForBooking=booking.getNoOfSeats();//3
		Train train=booking.getTrain();
		int dbSeatsForTrain=train.getNoOfSeats();
		dbSeatsForTrain=dbSeatsForTrain+dbSeatsForBooking;
		train.setNoOfSeats(dbSeatsForTrain);
		trainRepository.save(train);
		
		}
		return "canceled successfully";
	}

	public Booking getTrainDetails(int id) {
		Optional<Booking> booking=bookingRepository.findById(id);
		Booking presentBooking= booking.get();
		return presentBooking;
	}

	public ArrayList<Object> getTicketDetails(int id) {
		Optional<Booking> booking=bookingRepository.findById(id);
		Booking presentBooking=booking.get();
		Train train=presentBooking.getTrain();
		ArrayList<Object> arraylist=new ArrayList<Object>();
		arraylist.add(presentBooking);
		arraylist.add(train);
		return arraylist;
	}

	
	
}

