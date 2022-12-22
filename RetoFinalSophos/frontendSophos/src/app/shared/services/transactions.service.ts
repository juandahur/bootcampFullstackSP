import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, retry, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Transactions } from '../models/transactions.model';

@Injectable({
  providedIn: 'root'
})
export class TransactionsService {
  
  public url:string=environment.ApiUrl;
  constructor(public http:HttpClient) { }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  // HttpClient API get() method => Fetch transaction list
  getTransactions(): Observable<Transactions> {
    return this.http
      .get<Transactions>(this.url + '/transactions')
      .pipe(retry(1), catchError(this.handleError));
  }  
  
  getTransactionsByProduct(id: any): Observable<Transactions> {
    return this.http
      .get<Transactions>(this.url + '/transactions/' + id)
      .pipe(retry(1), catchError(this.handleError));
  }


  /// HttpClient API post() method => Create Transaction
  createTransaction(id: any, Transactions: any): Observable<Transactions> {
    return this.http
      .post<Transactions>(
        this.url + '/transactions/'+ id,
        JSON.stringify(Transactions),
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
