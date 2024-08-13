import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TheatreComponent } from './theatre.component';

describe('TheatreComponent', () => {
  let component: TheatreComponent;
  let fixture: ComponentFixture<TheatreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TheatreComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TheatreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
