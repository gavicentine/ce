import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConteudoDetailComponent } from './conteudo-detail.component';

describe('ConteudoDetailComponent', () => {
  let component: ConteudoDetailComponent;
  let fixture: ComponentFixture<ConteudoDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConteudoDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConteudoDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
