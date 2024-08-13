package com.CinemaApp.api;


import com.CinemaApp.model.CinemaUser;
import com.CinemaApp.service.CinemaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cinema_users")
public class CinemaUserController {

    @Autowired
    private final CinemaUserService cinemaUserService;

    public CinemaUserController(CinemaUserService cinemaUserService) {
        this.cinemaUserService = cinemaUserService;
    }

    @PostMapping
    public CinemaUser addCinemaUser(@RequestBody CinemaUser cinemaUser){
        return cinemaUserService.addCinemaUser(cinemaUser);
    }

}
