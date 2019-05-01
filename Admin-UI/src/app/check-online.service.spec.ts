import { TestBed } from '@angular/core/testing';

import { CheckOnlineService } from './check-online.service';

describe('CheckOnlineService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CheckOnlineService = TestBed.get(CheckOnlineService);
    expect(service).toBeTruthy();
  });
});
