import { Component, OnInit } from '@angular/core';
import {Referentes} from '../../referentes/referentes';
import {ReferenteService} from '../../referentes/referentes.service';
import {Router, ActivatedRoute} from '@angular/router';
import {Dificultad} from '../../dificultad/dificultad';
import {DificultadService} from '../../dificultad/dificultad.service';
import swal from 'sweetalert2';


@Component({
  selector: 'app-formreferentes',
  templateUrl: './formreferentes.component.html',
  styleUrls: ['./formreferentes.component.css']
})
export class FormreferentesComponent implements OnInit {

  private referentes: Referentes = new Referentes();
  private titulo:string ="Crear referente";
  private dificultades: Dificultad[];
  opcionSeleccionada: string="0";
  verSeleccion: number=null;


  constructor(private referenteService :ReferenteService, private dificultadService: DificultadService, private router : Router,
  private activatedRoute : ActivatedRoute) { }

  ngOnInit() {
    this.cargarReferentes()
    this.dificultadService.getDificultades().subscribe(
      dificultades => this.dificultades = dificultades
    );
  }
  cargarReferentes(): void{
    this.activatedRoute.params.subscribe(params => {
      let id = params['id']
      if(id){
        this.referenteService.getReferenteid(id).subscribe( (referentes) => this.referentes = referentes)
      }
    })
  }
  public create(): void {
    this.referenteService.create(this.referentes).subscribe(
      response =>{
         this.router.navigate(['/adminReferentes'])
         swal('Nuevo Referente', `Referente ${this.referentes.nombreReferente} creado con éxito`, 'success')
       }
    )
  }

  update(): void{
    this.referenteService.update(this.referentes).subscribe( cliente =>{
      this.router.navigate(['/adminReferentes'])
      swal('Referente Actualizado', `Referente ${this.referentes.nombreReferente} actualizado con exito`, 'success')
    })
  }

  asignar():void {
    this.dificultadService.asignReferente(this.referentes, this.verSeleccion).subscribe(
      response => {
        this.router.navigate(['/adminReferentes'])
        swal('Nuevo Referente', `Referente ${this.referentes.nombreReferente} creado con éxito`, 'success')
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
