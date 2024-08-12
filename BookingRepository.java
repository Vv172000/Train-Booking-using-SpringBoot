package com.railway.respo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.railway.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
