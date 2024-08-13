package com.CinemaApp.repository;

import com.CinemaApp.model.CinemaUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaUserRepository extends JpaRepository<CinemaUser, Long> {

}
