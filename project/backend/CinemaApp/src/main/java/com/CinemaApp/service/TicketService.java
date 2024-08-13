package com.CinemaApp.service;

import com.CinemaApp.model.*;
import com.CinemaApp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ScreeningRepository screeningRepository;

    @Autowired
    private CinemaUserRepository cinemaUserRepository;


    public TicketService(TicketRepository ticketRepository, SeatRepository seatRepository, MovieRepository movieRepository, ScreeningRepository screeningRepository, CinemaUserRepository cinemaUserRepository) {
        this.ticketRepository = ticketRepository;
        this.seatRepository = seatRepository;
        this.movieRepository = movieRepository;
        this.screeningRepository = screeningRepository;
        this.cinemaUserRepository = cinemaUserRepository;
    }

    public Ticket createTicket(int price, long movie_id, long screening_id, long seat_id, long user_id){
        Screening screening = screeningRepository.findById(screening_id).orElseThrow(() -> new RuntimeException("Screening not found"));
        Seat seat = seatRepository.findById(seat_id).orElseThrow(() -> new RuntimeException("Seat not found"));
        CinemaUser cinemaUser = cinemaUserRepository.findById(user_id).orElseThrow(() -> new RuntimeException("User not found"));
        Movie movie = movieRepository.findById(movie_id).orElseThrow(() -> new RuntimeException("Movie not found"));

        Ticket ticket = new Ticket();

        ticket.setScreening(screening);
        ticket.setMovie(movie);
        ticket.setSeat(seat);
        ticket.setCinemaUser(cinemaUser);
        ticket.setPrice(price);

        return ticketRepository.save(ticket);
    }

    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

}
