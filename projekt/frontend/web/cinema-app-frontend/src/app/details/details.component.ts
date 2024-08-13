import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MovieDetails } from '../movie-details';
import { ActivatedRoute } from '@angular/router';
import { MoviesService } from '../movies.service';
import { TheatreComponent } from '../theatre/theatre.component';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-details',
  standalone: true,
  imports: [CommonModule, TheatreComponent],
  template: `
    <article class="movie" *ngIf="movieDetails$ | async as movieDetails">
      <div class="movie-content">
        <img class="movie-photo" [src]="movieDetails.image" alt="{{movieDetails.name}}">
        <section class="movie-description">
          <h1 class="movie-heading">{{movieDetails.name}}</h1>
          <p>{{movieDetails.description}}</p>
          <h2 class="movie-genre">Genre: {{movieDetails.genre}}</h2>
          <p class="movie-director">Director: {{movieDetails.director}}</p>
          <p class="movie-actors">Actors: {{movieDetails.actors}}</p>
          <h2 class="movie-duration">Duration: {{movieDetails.duration}} minutes</h2>
        </section>
      </div>
    </article>

    <<div class="screenings">
      <h2>Screening Times</h2>
      <div *ngFor="let screening of screenings$ | async">
        <button (click)="selectScreening(screening.id)">{{ screening.date }} {{ screening.start_time }}</button>
      </div>
    </div>>

    <app-theatre *ngIf="selectedScreeningId" [screeningId]="selectedScreeningId"></app-theatre>
  `,
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  movieDetails$!: Observable<MovieDetails>;
  screenings$!: Observable<any[]>;
  selectedScreeningId!: number;

  constructor(
    private route: ActivatedRoute,
    private moviesService: MoviesService
  ) {}

  ngOnInit() {
    const movieId = +this.route.snapshot.paramMap.get('id')!;
    this.movieDetails$ = this.moviesService.getMovieById(movieId);
    this.screenings$ = this.moviesService.getScreeningsByMovieId(movieId);
  }

  selectScreening(screeningId: number) {
    console.log('Selected Screening ID:', screeningId);
    this.selectedScreeningId = screeningId;
  }
}
