import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-singleproduct',
  templateUrl: './singleproduct.component.html',
  styleUrls: ['./singleproduct.component.css']
})
export class SingleproductComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  stemp = localStorage.getItem('singleprod');
  singleprod = JSON.parse(this.stemp);

}
