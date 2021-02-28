import { Component, OnInit } from '@angular/core';
import {Dificultad} from './dificultad';
import {DificultadService} from './dificultad.service';
import {ActivatedRoute, Router} from '@angular/router'

@Component({
  selector: 'app-dificultad',
  templateUrl: './dificultad.component.html',
  styleUrls: ['./dificultad.component.css']
})
export class DificultadComponent implements OnInit {

  private dificultades: Dificultad[];
  private dificul: Dificultad= new Dificultad();
  isCollapse = true;   // guardamos el valor
    toggleState() { // manejador del evento
        let foo = this.isCollapse;
        this.isCollapse = foo === true ? false : true;
    }
  constructor(private dificultadService: DificultadService, private ActivatedRoute: ActivatedRoute) {
   }

    ngOnInit() {
    this.indicePagina();
    this.dificultadService.getDificultades().subscribe(
      dificultades => this.dificultades = dificultades
    );

  }
  indicePagina(): void{
    this.ActivatedRoute.params.subscribe(params =>{
      let id = params['id']
      if(id){
        this.dificultadService.getDificultad(id).subscribe( dificultades => this.dificul = dificultades)
      }
    })
  }



}
