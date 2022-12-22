import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, retry, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Products } from '../models/products.model';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  public url:string=environment.ApiUrl;
  constructor(public http:HttpClient) { }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  // HttpClient API get() method => Fetch clients list
  getProducts(): Observable<Products> {
    return this.http
      .get<Products>(this.url + '/products')
      .pipe(retry(1), catchError(this.handleError));
  }  
  
  getProductsByClient(id: any): Observable<Products> {
    return this.http
      .get<Products>(this.url + '/products/' + id)
      .pipe(retry(1), catchError(this.handleError));
  }

   /// HttpClient API post() method => Create Product
   createProduct(id: any,accountType: any): Observable<Products> {
    let Product = {accountType:accountType};
    
    return this.http
      .post<Products>(
        this.url + '/products/' + id,
        JSON.stringify(Product),
        this.httpOptions
      )
      .pipe(retry(1), catchError(this.handleError));
  }

  /// HttpClient API post() method => Create Product
  updateProduct(id: any,productState: any): Observable<Products> {
    let Product = {productState:productState};
    
    return this.http
      .patch<Products>(
        this.url + '/products/state/' + id,
        JSON.stringify(Product),
        this.httpOptions
      )
      .pipe(retry(1), catchError(this.handleError));
  }


  // Error handling
  handleError(error: any) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.error}`;
    }
    window.alert(errorMessage);
    return throwError(() => {
      return errorMessage;
    });
  }


  
}
