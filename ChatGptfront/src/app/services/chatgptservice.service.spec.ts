import { TestBed } from '@angular/core/testing';

import { ChatgptserviceService } from './chatgptservice.service';

describe('ChatgptserviceService', () => {
  let service: ChatgptserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ChatgptserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
