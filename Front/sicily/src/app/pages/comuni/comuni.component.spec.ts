import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComuniComponent } from './comuni.component';

describe('ComuniComponent', () => {
  let component: ComuniComponent;
  let fixture: ComponentFixture<ComuniComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ComuniComponent]
    });
    fixture = TestBed.createComponent(ComuniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
