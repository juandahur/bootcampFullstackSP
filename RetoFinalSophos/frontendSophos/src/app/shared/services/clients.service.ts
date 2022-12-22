import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Clients } from '../models/clients.model';

@Injectable({
  providedIn: 'root'
})
export class ClientsService {

  public url:string=environment.ApiUrl;

  constructor(public http:HttpClient) {}

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };
  
  // HttpClient API get() method => Fetch clients list
  getClients(): Observable<Clients> {
    return this.http
      .get<Clients>(this.url + '/clients')
      .pipe(retry(1), catchError(this.handleError));
  }  
  
  // HttpClient API get(id) method => Fetch client
  getClient(id: any): Observable<Clients> {
    return this.http
      .get<Clients>(this.url + '/clients/' + id)
      .pipe(retry(1), catchError(this.handleError));
  }

  /// HttpClient API post() method => Create client
  createClient(Clients: any): Observable<Clients> {
    return this.http
      .post<Clients>(
        this.url + '/clients',
        JSON.stringify(Clients),
        this.httpOptions
      )
      .pipe(retry(1), catchError(this.handleError));
  }

   // HttpClient API put() method => Update client
   updateClient(id: any, Clients: any): Observable<Clients> {
    return this.http
      .patch<Clients>(
        this.url + '/clients/' + id,
        JSON.stringify(Clients),
        this.httpOptions
      )
      .pipe(retry(1), catchError(this.handleError));
  }
  // Delete client 
  deleteClient(id: any) {
    return this.http
      .delete<Clients>(this.url + '/clients/' + id, this.httpOptions)
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
