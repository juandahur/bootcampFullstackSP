import { Component, OnInit } from '@angular/core';
import { Clients } from 'src/app/shared/models/clients.model';
import { ClientsService } from 'src/app/shared/services/clients.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductsService } from 'src/app/shared/services/products.service';

@Component({
  selector: 'app-clients-list',
  templateUrl: './clients-list.component.html',
  styleUrls: ['./clients-list.component.css']
})
export class ClientsListComponent implements OnInit{

  id = this.actRoute.snapshot.params['id'];
  productData: any = {};

  constructor(
    public serviceClients: ClientsService,
    public serviceProducts: ProductsService,
    public actRoute: ActivatedRoute,
    public router: Router
  )
  {}

  Clients: any=[];
  ngOnInit(): void {
    this.getClients();
    
  }

   // Get clients list
   getClients() {
    return this.serviceClients.getClients().subscribe(res=>this.Clients=res);
    };

    deleteClient(id: any){
     
        if (window.confirm('Are you sure, you want to delete?')) {
          this.serviceClients.deleteClient(id).subscribe((data) => {
            this.getClients();
          });
        }
    }

    createProduct(id: any, productData: any) {
      if(window.confirm('Are you sure, you want to update?')){
          this.serviceProducts.createProduct(id, productData).subscribe(data => {
          this.router.navigate(['/products',id])
        })
      }
    }


}
