import { Component, OnInit } from '@angular/core';
import {Referentes} from '../../referentes/referentes';
import {ReferenteService} from '../../referentes/referentes.service';
import {DificultadService} from '../../dificultad/dificultad.service';
import swal from 'sweetalert2'

@Component({
  selector: 'app-adminreferentes',
  templateUrl: './adminreferentes.component.html',
  styleUrls: ['./adminreferentes.component.css']
})
export class AdminreferentesComponent implements OnInit {

  referentes : Referentes[];
  constructor(private referenteService : ReferenteService, private dificultadService : DificultadService) { }

  ngOnInit() {
    this.referenteService.getReferente().subscribe(
      referentes => this.referentes = referentes
    );
  }
  delete(referente: Referentes): void {
    swal({
      title: 'Está seguro?',
      text: `¿Seguro que desea eliminar el referente ${referente.nombreReferente}?`,
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

        this.dificultadService.deleteReferente(referente).subscribe(
          response =>{
            this.referentes = this.referentes.filter(ref => ref !== referente)
            swal(
              'Referente eliminado',
              `Referente ${referente.nombreReferente} eliminado con exito`,
              'success'
            )
          },

        )
        this.referenteService.delete(referente.idReferente).subscribe(
          response =>{

          })

      }
    })
  }


}
