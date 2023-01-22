import { NgModule } from '@angular/core';

import { RouterModule, Routes } from '@angular/router';
import { CartComponent } from './cart/cart.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ProductsComponent } from './products/products.component';
import { SingleproductComponent } from './singleproduct/singleproduct.component';
import { UserRegisterComponent } from './user-register/user-register.component';









const routes: Routes = [
  {path:'',component:HomeComponent},
  {path: 'singleproduct', component: SingleproductComponent},
  {path: 'cart', component: CartComponent},
  {path:'user-register',component:UserRegisterComponent},
  {path:'navbar',component:NavbarComponent},
  {path:'home',component:HomeComponent},
  {path:'products',component:ProductsComponent},
  {path: 'products/:{id}', component:ProductsComponent},
  {path: 'home/products/:{id}', component:ProductsComponent},
  //{ path: '**', component: PageNotFoundComponent }

];



@NgModule({

  imports: [RouterModule.forRoot(routes)],

  exports: [RouterModule]

})

export class AppRoutingModule { }
export const routingComponents = [HomeComponent, UserRegisterComponent, NavbarComponent, ProductsComponent, CartComponent, SingleproductComponent]