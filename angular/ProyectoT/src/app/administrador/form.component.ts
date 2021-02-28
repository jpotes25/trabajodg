import { Component, OnInit } from '@angular/core';
import {Dificultad} from '../dificultad/dificultad';
import {DificultadService} from '../dificultad/dificultad.service'
import {Router, ActivatedRoute} from '@angular/router'
import swal from 'sweetalert2'
@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  private dificultad: Dificultad = new Dificultad();
  private titulo:string ="Crear dificultad";


  constructor(private dificultadService :DificultadService, private router : Router,
  private activatedRoute : ActivatedRoute) { }

  ngOnInit() {
    this.cargarDificultad()
  }
  cargarDificultad(): void{
    this.activatedRoute.params.subscribe(params => {
      let id = params['id']
      if(id){
        this.dificultadService.getDificultad(id).subscribe ( (dificultad) => this.dificultad = dificultad)
      }
    })
  }
  public create(): void {
    this.dificultadService.create(this.dificultad).subscribe(
      response =>{
         this.router.navigate(['/administrador'])
         swal('Nueva dificultad', `Dificultad  ${this.dificultad.nombreDificultad} creado con éxito`, 'success')
       }
    )
  }

  update(): void{
    this.dificultadService.update(this.dificultad).subscribe( cliente =>{
      this.router.navigate(['/administrador'])
      swal('Dificultad Actualizada', `Dificultad ${this.dificultad.nombreDificultad} actualizada con exito`, 'success')
    })
  }


}
