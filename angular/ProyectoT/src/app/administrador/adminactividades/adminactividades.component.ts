import { Component, OnInit } from '@angular/core';
import {Actividades} from '../../actividades/actividades';
import {ActividadesService} from '../../actividades/actividades.service';
import {DificultadService} from '../../dificultad/dificultad.service';
import swal from 'sweetalert2'

@Component({
  selector: 'app-adminactividades',
  templateUrl: './adminactividades.component.html',
  styleUrls: ['./adminactividades.component.css']
})
export class AdminactividadesComponent implements OnInit {

  actividad : Actividades[];
  constructor(private actividadService : ActividadesService, private dificultadService : DificultadService) { }

  ngOnInit() {
    this.actividadService.getActividades().subscribe(
      actividad => this.actividad = actividad
    );
  }
  delete(actividad: Actividades): void {
    swal({
      title: 'Está seguro?',
      text: `¿Seguro que desea eliminar la actividad ${actividad.nombreActividad}?`,
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, eliminar!',
      cancelButtonText: 'No, cancelar!',
      confirmButtonClass: 'btn btn-success',
      cancelButtonClass: 'btn btn-danger',
      buttonsStyling: false,
      reverseButtons: true
    }).then((result) => {
      if (result.value) {

        this.dificultadService.deleteActividad(actividad).subscribe(
          response =>{
            this.actividad = this.actividad.filter(act => act !== actividad)
            swal(
              'Actividad eliminada',
              `Actividad ${actividad.nombreActividad} eliminada con exito`,
              'success'
            )
          },

        )
        this.actividadService.delete(actividad.idActividad).subscribe(
          response =>{

          })

      }
    })
  }

}
