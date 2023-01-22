import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, observable } from 'rxjs';
import { User } from '../user-register/user';
import { User1 } from '../user-register/user1';

@Injectable({
  providedIn: 'root'
})
export class UserApiService {
  // private baseurl="http://localhost:8080/user/save";
  
  constructor(private httpClient: HttpClient) { }

  userSignup(user : User):Observable<object>{
  console.log(user)
    return this.httpClient.post<object>(`http://localhost:8080/user/saveUser`,user); 
  }
  userLogin(user1 : User1):Observable<object>{
    console.log(user1)
      return this.httpClient.post<object>(`http://localhost:8080/login/loginUser`,user1);

}
}
