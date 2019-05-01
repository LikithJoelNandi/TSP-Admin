import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EnrollSubscriberComponent } from './enroll-subscriber.component';

describe('EnrollSubscriberComponent', () => {
  let component: EnrollSubscriberComponent;
  let fixture: ComponentFixture<EnrollSubscriberComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EnrollSubscriberComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EnrollSubscriberComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
