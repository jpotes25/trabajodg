import { Component, OnInit } from '@angular/core';
import {Dificultad} from '../dificultad/dificultad';
import {DificultadService} from '../dificultad/dificultad.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  
  dificultades: Dificultad[];

  constructor(private dificultadService: DificultadService) { }

  ngOnInit(){
    this.dificultadService.getDificultades().subscribe(
      dificultades => this.dificultades = dificultades
    );
  }
}
