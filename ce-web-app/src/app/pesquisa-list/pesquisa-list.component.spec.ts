import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PesquisaListComponent } from './pesquisa-list.component';

describe('PesquisaListComponent', () => {
  let component: PesquisaListComponent;
  let fixture: ComponentFixture<PesquisaListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PesquisaListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PesquisaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
