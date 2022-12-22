import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TransactionsService } from 'src/app/shared/services/transactions.service';

@Component({
  selector: 'app-transactions-product',
  templateUrl: './transactions-product.component.html',
  styleUrls: ['./transactions-product.component.css']
})
export class TransactionsProductComponent implements OnInit{

  constructor(public serviceTransactions: TransactionsService, private route: ActivatedRoute){}

  Transactions: any=[];
  
  
  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.getTransactionsByProduct(id);
    
  }

   // Get clients list
   getTransactionsByProduct(id: any) {
    return this.serviceTransactions.getTransactionsByProduct(id).subscribe(res=>this.Transactions=res);
    };

}
