import { Component, OnInit } from '@angular/core';
import {Dificultad} from '../dificultad/dificultad';
import {DificultadService} from '../dificultad/dificultad.service';
import swal from 'sweetalert2'


@Component({
  selector: 'app-administrador',
  templateUrl: './administrador.component.html',
  styleUrls: ['./administrador.component.css']
})
export class AdministradorComponent implements OnInit {

  dificultades: Dificultad[];
  constructor(private dificultadService: DificultadService) { }

  ngOnInit() {
    this.dificultadService.getDificultades().subscribe(
      dificultades => this.dificultades = dificultades
    );
  }

  delete(dificultad: Dificultad): void {
    swal({
      title: 'Está seguro?',
      text: `¿Seguro que desea eliminar la dificultad ${dificultad.nombreDificultad}?`,
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

        this.dificultadService.delete(dificultad.idDificultad).subscribe(
          response =>{
            this.dificultades = this.dificultades.filter(dif => dif !== dificultad)
            swal(
              'Dificultad eliminada',
              `Dificultad ${dificultad.nombreDificultad} eliminada con exito`,
              'success'
            )
          }
        )

      }
    })
  }

}
