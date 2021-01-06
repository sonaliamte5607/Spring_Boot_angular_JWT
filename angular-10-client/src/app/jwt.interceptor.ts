// import { Injectable } from '@angular/core';
// import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
// import { Observable } from 'rxjs';
// import {TokenStorageService } from './_services/token-storage.service';

// @Injectable({
//     providedIn: 'root'
//   })
// export class JwtInterceptor implements HttpInterceptor {
//     constructor(private tokenService: TokenStorageService) {}

//     intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
//         // add authorization header with jwt token if available
//         let token = this.tokenService.getToken();
//             request = request.clone({
//                 setHeaders: {
//                     Authorization: `Bearer ${token}`
//                 }
//             });
//         }
//         return next.handle(request);
//     }
// }