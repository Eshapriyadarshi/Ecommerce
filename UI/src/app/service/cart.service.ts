import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { ProductsComponent } from '../products/products.component';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  public cartItemList : any =[]
  public productList = new BehaviorSubject<any>([]);
  public search = new BehaviorSubject<string>("");
  // let productcomponent = new ProductsComponent();

  constructor(private httpClient: HttpClient) { }
  getProducts(){
    return this.productList.asObservable();
  }

  setProduct(product : any){
    this.cartItemList.push(...product);
    this.productList.next(product);
  }
  sendCart(cart: any){
    return this.httpClient.post<object>(`http://localhost:8080/Cart/addCart`,cart);
  }

  addtoCart(product:any){
    this.cartItemList.push(product);
      this.productList.next(this.cartItemList);
      this.getTotalPrice();
      console.log(this.cartItemList)
  }
  
  getTotalPrice() : number{
    let grandTotal = 0;
    this.cartItemList.map((a:any)=>{
      grandTotal += a.total;
    })
    return grandTotal;
  }
  removeCartItem(product: any){
    this.cartItemList.map((a:any, index:any)=>{
      if(product.id=== a.id){
        this.cartItemList.splice(index,1);
      }
    })
    this.productList.next(this.cartItemList);
  }
  removeAllCart(){
    this.cartItemList = []
    this.productList.next(this.cartItemList);
  }
}
