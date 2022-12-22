import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductsService } from 'src/app/shared/services/products.service';
import { TransactionsService } from 'src/app/shared/services/transactions.service';

@Component({
  selector: 'app-transactions-create',
  templateUrl: './transactions-create.component.html',
  styleUrls: ['./transactions-create.component.css']
})
export class TransactionsCreateComponent implements OnInit{

  @Input() transactionDetails = { 
    transactionType: '',
    value:'',
    destinationAccountId:'',
  };

  listTransactionTypes: string[] = ['deposit','withdrawal','transfer'];
 
  

  constructor(
    public serviceTransaction: TransactionsService,
    public serviceProducts: ProductsService, 
    public router: Router,
    private route: ActivatedRoute) {}

    Products: any=[];
    ProductsId: any=[];
    ngOnInit(): void {
      this.getProducts();
      
    }

    getProducts() {
      return this.serviceProducts.getProducts().subscribe(res=>this.Products=res);
      };

    createTransaction(dataTransaction: any) {
      const id = this.route.snapshot.paramMap.get('id');
      if(dataTransaction.transactionType == "deposit" || dataTransaction.transactionType == "withdrawal"){
        dataTransaction.destinationAccountId = id;
      }
      
      this.serviceTransaction.createTransaction(id, this.transactionDetails).subscribe((data: {}) => {
      this.router.navigate(['/transactions']);
    });
  }

}
