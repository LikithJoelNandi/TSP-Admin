import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';
import { User } from '../_models/user';

const endpoint = 'http://localhost:8888/api/v1/';

@Injectable({
  providedIn: 'root'
})
export class SigninService {
  public user: User;

  constructor(private http: HttpClient) {
    this.user = new User();
   }

  private extractData(res: Response) {
    let body = res;
    return body || { };
  }



  checkCredentials(userName, password): Observable<any> {
    console.log('in sign in service');
    let myparams = new HttpParams();
    this.user.mobileNo = userName;
    this.user.password = password;
    return this.http.post(
      endpoint+'signin',
      this.user,
      {responseType: 'text'});
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
  
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
  
      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);
  
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
