import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyOfferComponent } from './modify-offer.component';

describe('ModifyOfferComponent', () => {
  let component: ModifyOfferComponent;
  let fixture: ComponentFixture<ModifyOfferComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModifyOfferComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifyOfferComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
