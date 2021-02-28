import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-conozcanos',
  templateUrl: './conozcanos.component.html',
  styleUrls: ['./conozcanos.component.css']
})
export class ConozcanosComponent implements OnInit {

  constructor(private ActivatedRoute: ActivatedRoute) { }

  ngOnInit() {
  }

}
