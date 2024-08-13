import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-seat',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './seat.component.html',
  styleUrls: ['./seat.component.css']
})
export class SeatComponent {
  @Input() seat!: { id: number, status: boolean };
  @Input() selected: boolean = false;
  @Input() seatNumber! : number;
  @Output() select = new EventEmitter<number>();

  onSelect() {
    if (this.seat.status === true) {
      this.select.emit(this.seat.id);
    }
  }
}
