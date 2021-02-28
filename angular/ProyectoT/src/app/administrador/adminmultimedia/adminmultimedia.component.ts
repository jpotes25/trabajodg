import { Component, OnInit } from '@angular/core';
import {Multimedia} from '../../multimediadif/multimedia';
import {MultimediaService} from '../../multimediadif/multimedia.service';
import {DificultadService} from '../../dificultad/dificultad.service';
import swal from 'sweetalert2'


@Component({
  selector: 'app-adminmultimedia',
  templateUrl: './adminmultimedia.component.html',
  styleUrls: ['./adminmultimedia.component.css']
})
export class AdminmultimediaComponent implements OnInit {

  multimedias : Multimedia[];
  constructor(private multimediaService : MultimediaService, private dificultadService : DificultadService) { }

  ngOnInit() {
    this.multimediaService.getMultimedia().subscribe(
      multimedias => this.multimedias = multimedias
    );
  }
  delete(multimedias: Multimedia): void {
    swal({
      title: 'Está seguro?',
      text: `¿Seguro que desea eliminar la multimedia ${multimedias.nombreMultimedia}?`,
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

        this.dificultadService.deleteMultimedia(multimedias).subscribe(
          response =>{
            this.multimedias = this.multimedias.filter(mul => mul !== multimedias)
            swal(
              'Multimedia eliminada',
              `Multimedia ${multimedias.nombreMultimedia} eliminada con exito`,
              'success'
            )
          },

        )
        this.multimediaService.delete(multimedias.idMultimedia).subscribe(
          response =>{

          })

      }
    })
  }

}
