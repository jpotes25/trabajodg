import { Injectable } from '@angular/core';
import {ACTIVIDAD} from './actividades.json';
import {Actividades} from './actividades';
import {of, Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http'

@Injectable()
export class ActividadesService {
  private urlEndPoint: string = 'http://localhost:8080/api/actividades';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});


  constructor(private http: HttpClient) { }
  getActividades(): Observable<Actividades[]>{
    //return of(DIFICULTADES);
    return this.http.get<Actividades[]>(this.urlEndPoint)
  }

  getActividadid(idActividades): Observable<Actividades>{

    return this.http.get<Actividades>(`${this.urlEndPoint}/${idActividades}`)

  }

  create(actividad: Actividades) : Observable<Actividades>{

    return this.http.post<Actividades>(this.urlEndPoint, actividad, {headers: this.httpHeaders})
  }

  update(actividad: Actividades): Observable<Actividades>{
    return this.http.put<Actividades>(`${this.urlEndPoint}/${actividad.idActividad}`, actividad, {headers: this.httpHeaders})
  }

  delete(id: number): Observable<Actividades>{
    return this.http.delete<Actividades>(`${this.urlEndPoint}/${id}`, {headers: this.httpHeaders})
  }




}
