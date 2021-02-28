import { Injectable } from '@angular/core';
import {DIFICULTADES} from './dificultad.json';
import {Dificultad} from './dificultad';
import {of, Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Multimedia} from '../multimediadif/multimedia';
import {Actividades} from '../actividades/actividades';
import {Referentes} from '../referentes/referentes';



@Injectable()
export class DificultadService {
  private urlEndPoint: string = 'http://localhost:8080/api/dificultad';
  private urlEndPointAsign: string = 'http://localhost:8080/api/dificultad/asign';
  private urlEndPointAsignD: string = 'http://localhost:8080/api/dificultad/deletem';
  private urlEndPointActividad: string = 'http://localhost:8080/api/dificultad/actividad';
  private urlEndPointDelActividad: string = 'http://localhost:8080/api/dificultad/delactividad';
  private urlEndPointReferente: string = 'http://localhost:8080/api/dificultad/referente';
  private urlEndPointDelReferente: string = 'http://localhost:8080/api/dificultad/delreferentes';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})

  constructor(private http: HttpClient) { }
  getDificultades(): Observable<Dificultad[]>{
    //return of(DIFICULTADES);
    return this.http.get<Dificultad[]>(this.urlEndPoint)
  }
  getDificultad(idDificultad): Observable<Dificultad>{

    return this.http.get<Dificultad>(`${this.urlEndPoint}/${idDificultad}`)

  }

  create(dificultad: Dificultad) : Observable<Dificultad>{
    return this.http.post<Dificultad>(this.urlEndPoint, dificultad, {headers: this.httpHeaders})
  }

  update(dificultad: Dificultad): Observable<Dificultad>{
    return this.http.put<Dificultad>(`${this.urlEndPoint}/${dificultad.idDificultad}`, dificultad, {headers: this.httpHeaders})
  }

  delete(id: number): Observable<Dificultad>{
    return this.http.delete<Dificultad>(`${this.urlEndPoint}/${id}`, {headers: this.httpHeaders})
  }

  //metodos multimedia
  asign(multimedia: Multimedia, idDificultad:number): Observable<Multimedia>{
    return this.http.put<Multimedia>(`${this.urlEndPointAsign}/${idDificultad}`, multimedia, {headers: this.httpHeaders})
  }
  deleteMultimedia(multimedia: Multimedia): Observable<Multimedia>{
    const options = {
    body: multimedia,
    headers: this.httpHeaders,

    };
    return this.http.delete<Multimedia>(`${this.urlEndPointAsignD}`, options)
  }

//fin metodos multimedia

//metodos Actividades
asignActividad(actividad: Actividades, idDificultad:number): Observable<Actividades>{
  return this.http.put<Actividades>(`${this.urlEndPointActividad}/${idDificultad}`, actividad, {headers: this.httpHeaders})
}
deleteActividad(actividad: Actividades): Observable<Actividades>{
  const options = {
  body: actividad,
  headers: this.httpHeaders,

  };
  return this.http.delete<Actividades>(`${this.urlEndPointDelActividad}`, options)
}

// metodos Referentes

asignReferente(referente: Referentes, idDificultad:number): Observable<Referentes>{
  return this.http.put<Referentes>(`${this.urlEndPointReferente}/${idDificultad}`, referente, {headers: this.httpHeaders})
}
deleteReferente(referente: Referentes): Observable<Referentes>{
  const options = {
  body: referente,
  headers: this.httpHeaders


  };
  return this.http.delete<Referentes>(`${this.urlEndPointDelReferente}`, options)
}

}
