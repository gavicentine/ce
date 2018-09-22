import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConteudoListComponent } from './conteudo-list.component';

describe('ConteudoListComponent', () => {
  let component: ConteudoListComponent;
  let fixture: ComponentFixture<ConteudoListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConteudoListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConteudoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
