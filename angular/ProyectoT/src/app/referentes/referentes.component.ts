import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Dificultad} from '../dificultad/dificultad';
import {DificultadService} from '../dificultad/dificultad.service';


@Component({
  selector: 'app-referentes',
  templateUrl: './referentes.component.html',
  styleUrls: ['./referentes.component.css']
})
export class ReferentesComponent implements OnInit {

  private dificul: Dificultad = new Dificultad();
  player: YT.Player;
  isCollapse = true;
    toggleState(){
      let foo = this.isCollapse;
      this.isCollapse = foo == true ? false : true;
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
