package com.CinemaApp.model;

import jakarta.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private CinemaUser cinemaUser;

    @ManyToOne
    @JoinColumn(name = "screening_id", nullable = false)
    private Screening screening;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @OneToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

    public Ticket(){

    }

    public Ticket(long id, int price, CinemaUser cinemaUser, Screening screening, Movie movie, Seat seat) {
        this.id = id;
        this.price = price;
        this.cinemaUser = cinemaUser;
        this.screening = screening;
        this.movie = movie;
        this.seat = seat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CinemaUser getCinemaUser() {
        return cinemaUser;
    }

    public void setCinemaUser(CinemaUser cinemaUser) {
        this.cinemaUser = cinemaUser;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
