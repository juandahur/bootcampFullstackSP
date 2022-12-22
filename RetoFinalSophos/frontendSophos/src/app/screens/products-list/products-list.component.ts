import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductsService } from 'src/app/shared/services/products.service';

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.css']
})
export class ProductsListComponent implements OnInit {

  id = this.actRoute.snapshot.params['id'];
  productData: any = {};

  constructor(public serviceProducts: ProductsService,
    public actRoute: ActivatedRoute,
    public router: Router){}
  
  Products: any=[];
  
  ngOnInit(): void {
    this.getProducts();
    
    
  }

   // Get clients list
   getProducts() {
    
    return this.serviceProducts.getProducts().subscribe(res=>this.Products=res);
    
    };

    redirectTo(uri:string){
      this.router.navigateByUrl('/', {skipLocationChange: true}).then(()=>
      this.router.navigate([uri]));
   }

    updateProduct(id: any, productData: any) {
      if(window.confirm('Are you sure, you want to update?')){
        //console.log(id, ' ', productData,'  ' ,clientId);
        this.serviceProducts.updateProduct(id, productData).subscribe(data => {
          this.redirectTo('/products');
          
        })
      }
    }

}
