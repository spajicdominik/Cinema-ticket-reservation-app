package com.CinemaApp.service;

import com.CinemaApp.model.Movie;
import com.CinemaApp.model.Screening;
import com.CinemaApp.repository.MovieRepository;
import com.CinemaApp.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScreeningService {

    @Autowired
    private final ScreeningRepository screeningRepository;

    @Autowired
    private MovieRepository movieRepository;

    public Screening createScreening(String startTime, String date, long movieId, boolean ongoing){
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));
        Screening screening = new Screening();

        screening.setStartTime(startTime);
        screening.setDate(date);
        screening.setMovie(movie);
        screening.setOngoing(ongoing);

        return screeningRepository.save(screening);
    }

    public ScreeningService(ScreeningRepository screeningRepository, MovieRepository movieRepository) {
        this.screeningRepository = screeningRepository;
        this.movieRepository = movieRepository;
    }

    public Screening addScreening(Screening screening) {
        return screeningRepository.save(screening);
    }

    
    public List<Screening> getAllScreenings(){
        return screeningRepository.findAll();
    }

    public Optional<Screening> getScreeningById(Long id) {
        return screeningRepository.findById(id);
    }

    public List<Screening> getScreeningsByMovieId(Long movieId) {
        return screeningRepository.findByMovieId(movieId);
    }

    public List<Screening> getScreeningsByMovieIdQueryParam(Long movieId) {
        return screeningRepository.findByMovieId(movieId);
    }
}
