# Spring_Boot_angular_WT


In this tutorial, I will show you how to build a full stack Angular 10 + Spring Boot JWT Authentication with Employee Management and logger example. The back-end server uses Spring Boot with Spring Security for JWT Authentication & Authorization, Spring Data JPA for interacting with database and logger. The front-end will be built using Angular 10 with HttpInterceptor & Form validation.

## Angular 10 Spring Boot JWT Authentication and logger with Employee Management example
It will be a full stack, with Spring Boot for back-end and Angular 10 for front-end. The system is secured by Spring Security with JWT Authentication.

Manager can signup new account, login with username & password.

– Anyone can access a public page before logging in:
– New Manager registration:
– Signup Form Validation:
– After signup is successful, Manager can login:
-Loggedin Manager can access Profile page/ Manager page:

## Flow for Manager Registration and Manager Login

It’s not too difficult to understand. We have 2 endpoints for authentication:

* `api/auth/signup` for Manager Registration
* `api/auth/signin` for Manager Login

## Flow for Employee Create,Upadte,Delete
* `/api/v1/employees` for Get employee
* `/api/v1/employees/{id}` for Get By Id employee
* `/api/v1/employees` for Post method for Create employee
* `/api/v1/employees/{id}` for Put method for Update employee
* `/api/v1/employees/{id}` for delete method for Delete employee



If Client wants to send request to protected data/endpoints, a legal JWT must be added to HTTP Authorization Header.

## Spring Boot & Spring Security with Employee Management for Back-end
https://github.com/sonaliamte5607/Spring_Boot_angular_WT/tree/main/spring-boot-server

## Angular 10 with Employee Management for Front-end
https://github.com/sonaliamte5607/Spring_Boot_angular_WT/tree/main/angular-10-client
