import { Component, OnInit } from '@angular/core';
import { TransactionsService } from 'src/app/shared/services/transactions.service';

@Component({
  selector: 'app-transactions-list',
  templateUrl: './transactions-list.component.html',
  styleUrls: ['./transactions-list.component.css']
})
export class TransactionsListComponent implements OnInit{

  constructor(public serviceTransactions: TransactionsService){}
  
  Transactions: any=[];
  
  ngOnInit(): void {
    this.getTransactions();
    
  }

   // Get clients list
   getTransactions() {
    return this.serviceTransactions.getTransactions().subscribe(res=>this.Transactions=res);
    };

}
