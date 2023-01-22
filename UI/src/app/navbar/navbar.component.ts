import { Component, OnInit } from '@angular/core';
import { CartComponent } from '../cart/cart.component';
import { Global } from '../global';
import { ProductsComponent } from '../products/products.component';
import { CartService } from '../service/cart.service';
import { ProductsService } from '../service/products.service';
import { UserApiService } from '../service/user-api.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  public totalItem : number=0;
  public check1: boolean;
  user: string = Global.userProfile;
  constructor(private cartService: CartService,private userapi: UserApiService) {}

  ngOnInit() {
    this.cartService.getProducts()
    .subscribe(res=>{
      this.totalItem = res.length;
    })
    
  }

  logOut(){
    Global.login = false;
    window.location.reload();
  }


}


