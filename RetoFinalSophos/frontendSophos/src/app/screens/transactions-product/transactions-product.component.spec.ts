import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransactionsProductComponent } from './transactions-product.component';

describe('TransactionsProductComponent', () => {
  let component: TransactionsProductComponent;
  let fixture: ComponentFixture<TransactionsProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransactionsProductComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransactionsProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
