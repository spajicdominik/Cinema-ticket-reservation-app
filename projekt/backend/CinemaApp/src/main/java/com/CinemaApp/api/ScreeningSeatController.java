package com.CinemaApp.api;

import com.CinemaApp.model.ScreeningSeat;
import com.CinemaApp.service.ScreeningSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/screening_seat")
public class ScreeningSeatController {

    @Autowired
    private ScreeningSeatService screeningSeatService;

    public ScreeningSeatController(ScreeningSeatService screeningSeatService) {
        this.screeningSeatService = screeningSeatService;
    }

    @PostMapping
    public ScreeningSeat addScreeningSeat(@RequestBody ScreeningSeat screeningSeat) {
        return screeningSeatService.addScreeningSeat(screeningSeat);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScreeningSeat> getScreeningSeatById(@PathVariable Long id) {
        Optional<ScreeningSeat> screeningSeat = screeningSeatService.getScreeningSeatById(id);
        if (screeningSeat.isPresent()) {
            return ResponseEntity.ok(screeningSeat.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<ScreeningSeat> getAllScreeningSeat() {
        return screeningSeatService.getAllScreeningSeats();
    }

    @PutMapping("/{id}/reserve")
    public ResponseEntity<Void> ReserveSeat(@PathVariable long id) {
        boolean isUpdated = screeningSeatService.ReserveSeat(id);
        if (isUpdated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(params = "screening_id")
    public List<ScreeningSeat> getScreeningSeatByScreeningId(@RequestParam("screening_id") Long screeningId){
        return screeningSeatService.getScreeningSeatByScreeningId(screeningId);
    }

}
