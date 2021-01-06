import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Message } from '@angular/compiler/src/i18n/i18n_ast';


@Injectable({
  providedIn: 'root'
})


export class EmployeeService {

  currentUser: any;


    private baseUrl = 'http://localhost:8080/api/v1/employees';

  
  
    constructor(private http: HttpClient) { }

  
 

  getEmployee(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  
  createEmployee(employee: Object): Observable<Object> {

    return this.http.post(this.baseUrl, employee);
  }


  updateEmployee(id: number, value: Object): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getEmployeesList(): Observable<any> {
    return this.http.get(this.baseUrl);
   }
}

