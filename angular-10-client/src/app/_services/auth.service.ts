import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const AUTH_API = 'http://localhost:8080/api/auth/';
const baseUrl = 'http://localhost:8080/springboot-crud-rest/api/v1/';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(credentials): Observable<any> {
    return this.http.post(AUTH_API + 'signin', {
      username: credentials.username,
      email: credentials.email,
      password: credentials.password
    }, httpOptions);
  }

  register(user): Observable<any> {
    return this.http.post(AUTH_API + 'signup', {
      username:user.username,
       firstname: user.firstname,
       lastname: user.lastname,
       dob:user.dob,
       company:user.company,
      email: user.email,
      password: user.password
    }, httpOptions);
  }

  
  
  
}
