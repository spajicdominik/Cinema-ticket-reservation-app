import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScreeninglistComponent } from './screeninglist.component';

describe('ScreeninglistComponent', () => {
  let component: ScreeninglistComponent;
  let fixture: ComponentFixture<ScreeninglistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ScreeninglistComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ScreeninglistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
