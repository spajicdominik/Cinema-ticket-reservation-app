package com.CinemaApp.repository;


import com.CinemaApp.model.ScreeningSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreeningSeatRepository extends JpaRepository<ScreeningSeat, Long> {
    List<ScreeningSeat> findByScreeningId(Long screeningId);
}
