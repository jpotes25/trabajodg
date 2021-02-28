import { Component, OnInit } from '@angular/core';
import {Actividades} from '../../actividades/actividades';
import {ActividadesService} from '../../actividades/actividades.service';
import {Router, ActivatedRoute} from '@angular/router';
import {Dificultad} from '../../dificultad/dificultad';
import {DificultadService} from '../../dificultad/dificultad.service';

import swal from 'sweetalert2';

@Component({
  selector: 'app-formactividades',
  templateUrl: './formactividades.component.html',
  styleUrls: ['./formactividades.component.css']
})
export class FormactividadesComponent implements OnInit {

  private actividad: Actividades = new Actividades();
  private titulo:string ="Crear actividad";
  private dificultades: Dificultad[];
  opcionSeleccionada: string="0";
  verSeleccion: number=null;


  constructor(private actividadService :ActividadesService, private dificultadService: DificultadService, private router : Router,
  private activatedRoute : ActivatedRoute) { }

  ngOnInit() {
    this.cargarActividades()
    this.dificultadService.getDificultades().subscribe(
      dificultades => this.dificultades = dificultades
    );
  }
  cargarActividades(): void{
    this.activatedRoute.params.subscribe(params => {
      let id = params['id']
      if(id){
        this.actividadService.getActividadid(id).subscribe( (actividad) => this.actividad = actividad)
      }
    })
  }
  public create(): void {
    this.actividadService.create(this.actividad).subscribe(
      response =>{
         this.router.navigate(['/adminActividades'])
         swal('Nueva Actividad', `Actividad ${this.actividad.nombreActividad} creada con éxito`, 'success')
       }
    )
  }

  update(): void{
    this.actividadService.update(this.actividad).subscribe( cliente =>{
      this.router.navigate(['/adminActividades'])
      swal('Actividad Actualizada', `Actividad ${this.actividad.nombreActividad} actualizada con exito`, 'success')
    })
  }

  asignar():void {
    this.dificultadService.asignActividad(this.actividad, this.verSeleccion).subscribe(
      response => {
        this.router.navigate(['/adminActividades'])
        swal('Nueva Actividad', `Actividad ${this.actividad.nombreActividad} creada con éxito`, 'success')
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
