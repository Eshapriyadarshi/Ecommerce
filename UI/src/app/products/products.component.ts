import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { CommonResponse } from '../user-register/common-response';
import { ProductsService } from '../service/products.service';
import { Product } from './products';
import {Subscription} from "rxjs";
import { stringify } from 'querystring';
import { CartService } from '../service/cart.service';
import { Cart } from '../cart/cart';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { User1 } from '../user-register/user1';
import { Global } from '../global';



@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  status:any;
  user:User1 = new User1();
  commonRespo:CommonResponse = new CommonResponse();
  productList: any[];
  prod: Product;
  //private paramSub: Subscription;
  singleprod: any;
  stemp:any;
  cart: Cart = new Cart();
  // cartService: any;
  //param: {'2': 'electronics', '3': 'fashion', '4':'furnitures'}
 // temp:any;
  constructor(private route: Router, private productsService : ProductsService, private activatedRoute: ActivatedRoute,private cartService : CartService){}

  ngOnInit() :void{
     //this.showAll();
    //this.showByCategory('electronics');
    const type = this.activatedRoute.snapshot.url[1].path;
    console.log(type);
    if(type=='1'){
       this.showAll();
    }
    else if(type=='2'){
       this.showByCategory('electronics');
    }
    else if(type=='3')
      this.showByCategory('fashion'); 
    else
      this.showByCategory('furnitures');
  }

 
  

  showAll(){
     
    this.productsService.getAllProduct().subscribe(data=>{
      if(data['status']=="OK"){
        console.log(data['content']);
        this.productList=data['content'];
        console.log(this.productList);
        }

    });
    }
  
  showByCategory(prodCategory:string){
   
    this.productsService.getProductByCategory(prodCategory).subscribe(data=>{
    // this.productList.length=0;

      console.log("Category works",prodCategory);
      if(data['status']=="OK"){
       console.log("Data",data['content']);
       this.productList=data['content'];
      
       console.log("this product",this.productList);
       }

    });

    console.log(this.productList);  
    console.log(this.productList[1].productId);
   
    }

    viewproduct(p:any){

      console.log("click works");
      this.stemp=JSON.stringify(p);
      localStorage.setItem('singleprod',this.stemp);
      //this.route.navigate(['/singleproduct']);

  }
  // usertemp = ;
  usertemp = JSON.parse(localStorage.getItem('user3'));

  addProduct(item: any){
    if(Global.login==false)
    {
      alert("Please login first");
      this.route.navigate(['../user-register']);
    }
    else{
    this.cart.price = item.price;
    this.cart.quantity = 1;
    this.cart.product = item;
    this.cart.user = this.usertemp;
    this.cartService.sendCart(this.cart).subscribe((data)=>{
    this.commonRespo = data;
    console.log(this.cart);
    console.log(this.commonRespo.content)},error=>alert("Error"));
    if(this.commonRespo.status=="OK"){
      this.cartService.addtoCart(item);
      }
  }
}
  

}
