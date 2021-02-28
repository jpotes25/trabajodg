import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Dificultad} from '../dificultad/dificultad';
import {DificultadService} from '../dificultad/dificultad.service';

@Component({
  selector: 'app-actividades',
  templateUrl: './actividades.component.html',
  styleUrls: ['./actividades.component.css']
})
export class ActividadesComponent implements OnInit {

  private dificul: Dificultad= new Dificultad();
  player: YT.Player;
  isCollapse = true;   // guardamos el valor
    toggleState() { // manejador del evento
        let foo = this.isCollapse;
        this.isCollapse = foo === true ? false : true;
    }
    constructor(private dificultadService: DificultadService, private ActivatedRoute: ActivatedRoute) { }

    ngOnInit() {
      this.indicePagina();
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
