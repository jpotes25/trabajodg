import { Component, OnInit } from '@angular/core';
import {Multimedia} from '../../multimediadif/multimedia';
import {MultimediaService} from '../../multimediadif/multimedia.service';
import {Router, ActivatedRoute} from '@angular/router';
import {Dificultad} from '../../dificultad/dificultad';
import {DificultadService} from '../../dificultad/dificultad.service';

import swal from 'sweetalert2';

@Component({
  selector: 'app-formmultimedia',
  templateUrl: './formmultimedia.component.html',
  styleUrls: ['./formmultimedia.component.css']
})
export class FormmultimediaComponent implements OnInit {

  private multimedia: Multimedia = new Multimedia();
  private titulo:string ="Crear multimedia";
  private dificultades: Dificultad[];
  opcionSeleccionada: string="0";
  verSeleccion: number=null;


  constructor(private multimediaService :MultimediaService, private dificultadService: DificultadService, private router : Router,
  private activatedRoute : ActivatedRoute) { }

  ngOnInit() {
    this.cargarMultimedia()
    this.dificultadService.getDificultades().subscribe(
      dificultades => this.dificultades = dificultades
    );
  }

  cargarMultimedia(): void{
    this.activatedRoute.params.subscribe(params => {
      let id = params['id']
      if(id){
        this.multimediaService.getMultimediaid(id).subscribe( (multimedia) => this.multimedia = multimedia)
      }
    })
  }
  public create(): void {
    this.multimediaService.create(this.multimedia).subscribe(
      response =>{
         this.router.navigate(['/adminMultimedia'])
         swal('Nueva Multimedia', `Multimedia ${this.multimedia.nombreMultimedia} creado con éxito`, 'success')
       }
    )
  }

  update(): void{
    this.multimediaService.update(this.multimedia).subscribe( cliente =>{
      this.router.navigate(['/adminMultimedia'])
      swal('Dificultad Actualizada', `Dificultad ${this.multimedia.nombreMultimedia} actualizada con exito`, 'success')
    })
  }

  asignar():void {
    this.dificultadService.asign(this.multimedia, this.verSeleccion).subscribe(
      response => {
        this.router.navigate(['/adminMultimedia'])
        swal('Nueva Multimedia', `Multimedia ${this.multimedia.nombreMultimedia} creado con éxito`, 'success')
      }
    )
  }

  seleccion(): number{
    for(let dificultad of this.dificultades){
      if(dificultad.nombreDificultad == this.opcionSeleccionada){
        this.verSeleccion= dificultad.idDificultad;
      }
    }
    return this.verSeleccion;
  }



}
