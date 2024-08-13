package com.CinemaApp.api;


import com.CinemaApp.model.Movie;
import com.CinemaApp.model.Screening;
import com.CinemaApp.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/screening")
public class ScreeningController {

    @Autowired
    private ScreeningService screeningService;

    public ScreeningController(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }


    @PostMapping
    public Screening addScreening(@RequestBody Screening screening) {
        return screeningService.addScreening(screening);
    }

    @GetMapping
    public List<Screening> getAllScreenings(){
        return screeningService.getAllScreenings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Screening> getScreeningById(@PathVariable Long id) {
        Optional<Screening> screening = screeningService.getScreeningById(id);
        if(screening.isPresent()) {
            return ResponseEntity.ok(screening.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(params = "movie_id")
    public List<Screening> getScreeningsByMovieId(@RequestParam("movie_id") Long movieId) {
        return screeningService.getScreeningsByMovieId(movieId);
    }


}
