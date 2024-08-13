package com.CinemaApp.service;


import com.CinemaApp.model.CinemaUser;
import com.CinemaApp.repository.CinemaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaUserService {

    @Autowired
    private final CinemaUserRepository cinemaUserRepository;


    public CinemaUserService(CinemaUserRepository cinemaUserRepository) {
        this.cinemaUserRepository = cinemaUserRepository;
    }


    public CinemaUser addCinemaUser(CinemaUser cinemaUser) {
        return cinemaUserRepository.save(cinemaUser);
    }

}
