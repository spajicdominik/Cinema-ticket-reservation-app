import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MovieDetails } from './movie-details';

@Injectable({
  providedIn: 'root'
})
export class MoviesService {
  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  getAllMovies(): Observable<MovieDetails[]> {
    return this.http.get<MovieDetails[]>(`${this.apiUrl}/movies`);
  }

  getMovieById(id: number): Observable<MovieDetails> {
    return this.http.get<MovieDetails>(`${this.apiUrl}/movies/${id}`);
  }

  getScreeningsByMovieId(movieId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/screening?movie_id=${movieId}`);
  }

  getSeatsByScreeningId(screeningId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/screening_seat?screening_id=${screeningId}`);
  }

  updateSeatStatus(screening_seatId: number, status: boolean): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/screening_seat/${screening_seatId}/reserve`, { status });
  }
}
