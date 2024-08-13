import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MovieComponent } from '../movie/movie.component';
import { MovieDetails } from '../movie-details';
import { MoviesService } from '../movies.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, MovieComponent],
  template: `
  <h1 class="text-center">Movies that are screening right now</h1>
  <section class="results">
    <app-movie *ngFor="let movieDetails of movieDetailsList$ | async" [movieDetails]="movieDetails"></app-movie>
  </section>
  `,
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {
  movieDetailsList$!: Observable<MovieDetails[]>;

  constructor(private moviesService: MoviesService) {}

  ngOnInit() {
    this.movieDetailsList$ = this.moviesService.getAllMovies();
  }
}
