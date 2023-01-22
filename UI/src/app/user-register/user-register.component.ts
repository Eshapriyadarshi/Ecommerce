import { Component, OnInit } from '@angular/core';
import { CommonResponse } from './common-response';
import { User } from './user';
import { UserApiService } from '../service/user-api.service';
import { User1 } from './user1';
import { Router } from '@angular/router';
import { Global } from '../global';

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent implements OnInit {
temp:any;
  user:User = new User();
  user1:User1 = new User1();
  _router: any;
  userN: any;
  usertemp: any;
  user3: any;
  
  commonRespo:CommonResponse = new CommonResponse();
  constructor(private usersignup: UserApiService,private userlogin: UserApiService,private router: Router) { }

  ngOnInit():void {
  }
  
  signupUser()
  {
    console.log(this.user)
    this.usersignup.userSignup(this.user).subscribe((data)=>{
      this.temp=JSON.stringify(data);

      this.commonRespo=JSON.parse(this.temp);
      
      if(this.commonRespo.status=="User Already Exists"){

        alert("User Already Exists Kindly Login");}

      if(this.commonRespo.status=="OK"){

        alert("User Registered Successfully. Please Login");}

    },error=>alert("Sorry Please Enter Correct Details")); 
    
    // console.log(this.user)
    // this.usersignup.userLogin(this.user).subscribe((data1)=>{
      
    //   this.temp=JSON.stringify(data1);
      
    //   this.commonRespo=JSON.parse(this.temp);
      
    //   if(this.commonRespo.status=="Invalid emailid or password"){

    //     alert("Invalid login");}

    //   if(this.commonRespo.status=="OK"){

    //     alert("Login Successful");
    //     // this.userlogin.check = true;
        
    //     this._router.navigate(['../home']);
        

    //   }

    // },error=>alert("Sorry Please Enter Correct Details"));
  }

  loginUser()
  {
    console.log(this.user1)
    this.userlogin.userLogin(this.user1).subscribe((data1)=>{
      // let usertemp: any;
      // let status=data1['status'];
      // usertemp=data1['content'];
      // console.log(status);
      // temp=JSON.stringify(data1);
      this.commonRespo = data1;
      console.log(this.commonRespo.content);
      // this.commonRespo=JSON.parse(usertemp);
      
      
      if(this.commonRespo.status=="Invalid emailid or password"){

        alert("Invalid login");}

      if(this.commonRespo.status=="OK"){

        this.usertemp = JSON.stringify(this.commonRespo.content);
        Global.login = true;
        Global.userProfile = this.usertemp.firstName;
        localStorage.setItem('user3',this.usertemp);
        alert("Login Successful");
        this.router.navigate(['../home']);
        
      }

    },error=>alert("Sorry Please Enter Correct Details")); 
  }
  
}
