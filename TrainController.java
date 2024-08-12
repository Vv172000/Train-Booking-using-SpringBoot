package com.railway.controlller;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.railway.model.Train;
import com.railway.service.TrainService;
@Controller
@RestController
public class TrainController {
	@Autowired
	TrainService trainService;
	
	
	@PostMapping("/addTrain")
	public void addTrain(@RequestBody Train train){
		trainService.addTrainDetails(train);
	}
	
	@GetMapping("/trainDetails/{id}")
	public void trainDetailsById(@PathVariable int id){
		 trainService.trainDetailsById(id);
	}

	@GetMapping("/trainsDetails")
	public List<Train> trainDetails() {
	   return trainService.trainDetails();
	}
	
    @PutMapping("/updateTrain/{id}{arrivalTime}{departureTime}")
	public String updateTrain(@PathVariable int id,@RequestParam LocalTime arrivalTime,@RequestParam LocalTime departureTime) {	
		return trainService.updateTrain(id,arrivalTime,departureTime);
	}
	
    @DeleteMapping("/deleteTrain")
    public String deleteTrain(@PathVariable int id) {
    	return trainService.deleteTrain(id);
    }
	
	
	
	

}
