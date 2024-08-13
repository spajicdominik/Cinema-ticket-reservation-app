import { Component, Input } from '@angular/core';
import { MovieDetails } from '../movie-details';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-movie',
  standalone: true,
  imports: [RouterModule],
  template: `
   <section class="movie">
      <img class="movie-photo" [src]="movieDetails.image" alt="Movie poster of {{movieDetails.name}}">
      <h2 class="movie-heading">{{ movieDetails.name }}</h2>
      <p class="movie-description">{{ movieDetails.description }}</p>
      <div class="link-container">
        <a [routerLink]="['/details', movieDetails.id]" class="btn btn-primary">Details</a>
      </div>
    </section>

  `,
  styleUrl: './movie.component.css'
})
export class MovieComponent {
  @Input() movieDetails!: MovieDetails;
}
