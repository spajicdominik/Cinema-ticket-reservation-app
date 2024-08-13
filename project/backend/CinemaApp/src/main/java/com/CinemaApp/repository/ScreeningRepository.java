package com.CinemaApp.repository;

import com.CinemaApp.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreeningRepository extends JpaRepository<Screening,Long> {
    List<Screening> findByMovieId(Long movieId);
}
