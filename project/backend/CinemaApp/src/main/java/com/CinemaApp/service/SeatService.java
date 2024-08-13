package com.CinemaApp.service;


import com.CinemaApp.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SeatService {

    public SeatRepository seatRepository;
    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }





}
