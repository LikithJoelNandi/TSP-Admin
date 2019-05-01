import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateSingleOfferComponent } from './create-single-offer.component';

describe('CreateSingleOfferComponent', () => {
  let component: CreateSingleOfferComponent;
  let fixture: ComponentFixture<CreateSingleOfferComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateSingleOfferComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateSingleOfferComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
