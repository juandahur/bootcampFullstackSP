import { Component, Input, OnInit } from '@angular/core';
import { ProductsService } from 'src/app/shared/services/products.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-products-client',
  templateUrl: './products-client.component.html',
  styleUrls: ['./products-client.component.css']
})
export class ProductsClientComponent implements OnInit{

  
  constructor(
    public serviceProducts: ProductsService, 
    private route: ActivatedRoute,
    public router: Router
    ){}

  Products: any=[];
  id: any;
  
  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.getProductsByClient(this.id);
    
  }

   // Get clients list
   getProductsByClient(id: any) {
    return this.serviceProducts.getProductsByClient(id).subscribe(res=>this.Products=res);
    };

    redirectTo(uri:string,id:any){
      this.router.navigateByUrl('/', {skipLocationChange: true}).then(()=>
      this.router.navigate([uri,id]));
   }
    
    updateProduct(id: any, productData: any) {
      if(window.confirm('Are you sure, you want to update?')){
        //console.log(id, ' ', productData,'  ' ,clientId);
        this.serviceProducts.updateProduct(id, productData).subscribe(data => {
          this.redirectTo('/products',this.id);
          
        })
      }
    }

}
