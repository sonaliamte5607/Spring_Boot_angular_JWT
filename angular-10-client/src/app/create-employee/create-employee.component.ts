import { EmployeeService } from '../employee.service';
import { AuthService } from '../_services/auth.service';

import { Employee } from '../employee';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenStorageService } from '../_services/token-storage.service';


@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee: Employee = new Employee();
  submitted = false;
  form: any = {};
  

  constructor(private employeeService: EmployeeService,private tokenStorage: TokenStorageService,
    private router: Router) { }

  ngOnInit() {
    
  }

  newEmployee(): void {
    this.submitted = false;
    this.employee = new Employee();

  }

  save() {
    this.employeeService
    .createEmployee(this.employee).subscribe(data => {
      console.log(data)
      this.employee = new Employee();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    
    
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/show']);
  }
}
