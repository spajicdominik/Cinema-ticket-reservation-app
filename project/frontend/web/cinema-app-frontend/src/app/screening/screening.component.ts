import { Component, Input, Output, EventEmitter, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MoviesService } from '../movies.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-screening',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './screening.component.html',
  styleUrls: ['./screening.component.css']
})
export class ScreeningComponent implements OnInit {
  @Input() movieId!: number;
  @Output() screeningSelected = new EventEmitter<number>();
  screenings$!: Observable<any[]>;

  constructor(private moviesService: MoviesService) {}

  ngOnInit() {
    this.screenings$ = this.moviesService.getScreeningsByMovieId(this.movieId);
  }

  selectScreening(screeningId: number) {
    this.screeningSelected.emit(screeningId);
  }
}
