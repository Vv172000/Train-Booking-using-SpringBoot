package com.railway.service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.model.Train;
import com.railway.respo.TrainRepository;
@Service
public class TrainService {
	@Autowired
	TrainRepository trainRepository;
	public void addTrainDetails(Train  train) {
		trainRepository.save(train);
	}
	public List<Train> trainDetails() {
		return trainRepository.findAll();
		
	}
	public String updateTrain(int id,LocalTime at,LocalTime dt) {
	    Optional<Train> train= trainRepository.findById(id);
	    Train presentTrain=train.get();
	    presentTrain.setArrivalTime(at);
	    presentTrain.setDepartureTime(dt);
	    trainRepository.save(presentTrain);
		return "Details are updated";
	}
	public Train trainDetailsById(int id) {
		Optional<Train> train=trainRepository.findById(id);
		Train presentTrain=train.get();
		return presentTrain;
	}
	public String deleteTrain(int id) {
		 trainRepository.deleteById(id);
		 return "Train details are deleted successfully";
	}



}

