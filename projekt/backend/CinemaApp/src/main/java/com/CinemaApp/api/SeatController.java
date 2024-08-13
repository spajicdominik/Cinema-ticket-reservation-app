package com.CinemaApp.api;


import com.CinemaApp.model.Seat;
import com.CinemaApp.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    private final SeatService seatService;


    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }


}
