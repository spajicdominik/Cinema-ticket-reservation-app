package com.CinemaApp.service;

import com.CinemaApp.model.Movie;
import com.CinemaApp.model.Screening;
import com.CinemaApp.model.ScreeningSeat;
import com.CinemaApp.model.Seat;
import com.CinemaApp.repository.ScreeningRepository;
import com.CinemaApp.repository.ScreeningSeatRepository;
import com.CinemaApp.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScreeningSeatService {
    @Autowired
    private ScreeningSeatRepository screeningSeatRepository;

    @Autowired
    private ScreeningRepository screeningRepository;

    @Autowired
    private SeatRepository seatRepository;

    public ScreeningSeatService(ScreeningSeatRepository screeningSeatRepository, ScreeningRepository screeningRepository, SeatRepository seatRepository) {
        this.screeningSeatRepository = screeningSeatRepository;
        this.screeningRepository = screeningRepository;
        this.seatRepository = seatRepository;
    }

    public ScreeningSeat createScreeningSeat(boolean status, long seat_id, long screening_id) {
        Screening screening = screeningRepository.findById(screening_id).orElseThrow(() -> new RuntimeException("Screening not found"));
        Seat seat = seatRepository.findById(seat_id).orElseThrow(() -> new RuntimeException("Seat not found"));

        ScreeningSeat screeningSeat = new ScreeningSeat();

        screeningSeat.setScreening(screening);
        screeningSeat.setSeat(seat);
        screeningSeat.setStatus(status);

        return screeningSeatRepository.save(screeningSeat);
    }

    public ScreeningSeat addScreeningSeat(ScreeningSeat screeningSeat) {
        return screeningSeatRepository.save(screeningSeat);
    }

    public List<ScreeningSeat> getAllScreeningSeats() {
        return screeningSeatRepository.findAll();
    }

    public Optional<ScreeningSeat> getScreeningSeatById(Long id) {
        return screeningSeatRepository.findById(id);
    }

    public boolean ReserveSeat(long id) {
        Optional<ScreeningSeat> optionalScreeningSeat = screeningSeatRepository.findById(id);
        if (optionalScreeningSeat.isPresent()) {
            ScreeningSeat screeningSeat = optionalScreeningSeat.get();
            screeningSeat.setStatus(false);
            screeningSeatRepository.save(screeningSeat);
            return true;
        }else {
            return false;
        }
    }

    public List<ScreeningSeat> getScreeningSeatByScreeningId(Long screeningId){
        return screeningSeatRepository.findByScreeningId(screeningId);
    }

}
