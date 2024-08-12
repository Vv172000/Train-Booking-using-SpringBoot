package com.railway.respo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.railway.model.Train;

public interface TrainRepository extends JpaRepository<Train, Integer>{

}
