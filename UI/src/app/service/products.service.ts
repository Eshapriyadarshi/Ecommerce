import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CommonResponse } from '../user-register/common-response';


@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  baseurl = "http://localhost:8080/Home";
  constructor(private http:HttpClient) { }

  getAllProduct():Observable<CommonResponse[]>{
    // console.log(this.http.get(`${this.baseurl}`))
    console.log(this.http.get(`${this.baseurl}` + "/allProducts"));
    return this.http.get<CommonResponse[]>(`${this.baseurl}` + "/allProducts");
    }
   
    getProductByCategory(prodCategory:String):Observable<CommonResponse[]>{
    console.log(this.http.get(`${this.baseurl}/${prodCategory}`));
    // return this.http.get<CommonResponse[]>(`${this.baseurl}/${prodCategory}`);
    return this.http.get<CommonResponse[]>(`http://localhost:8080/Home/categories/${prodCategory}`)
   }

  // decreaseThatProduct(prodId:any,prodQty:any){
  //   let queryParams=new HttpParams();
  //   queryParams=queryParams.append("pId",prodId).append("pQty",prodQty);
  //   // console.log(localStorage.getItem('searchParam'));
  //   return this.http.get(`http://localhost:8081/checkout/placedorder`,{params:queryParams});
  //   console.log(this.http.post<String>(`${this.baseurl}`+prodId,String));
  //   return this.http.post<String>(`${this.baseurl}`+prodId,String);
  //   return this.http.post
  // } 
}
