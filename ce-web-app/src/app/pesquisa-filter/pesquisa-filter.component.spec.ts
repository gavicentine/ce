import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PesquisaFilterComponent } from './pesquisa-filter.component';

describe('PesquisaFilterComponent', () => {
  let component: PesquisaFilterComponent;
  let fixture: ComponentFixture<PesquisaFilterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PesquisaFilterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PesquisaFilterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
