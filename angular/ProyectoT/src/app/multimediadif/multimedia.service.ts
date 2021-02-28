import { Injectable } from '@angular/core';
import {MULTIMEDIA} from './multimedia.json';
import {Multimedia} from './multimedia';
import {of, Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http'

@Injectable()
export class MultimediaService {
  private urlEndPoint: string = 'http://localhost:8080/api/multimedia';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});


  constructor(private http: HttpClient) { }
  getMultimedia(): Observable<Multimedia[]>{
    //return of(DIFICULTADES);
    return this.http.get<Multimedia[]>(this.urlEndPoint)
  }
  getMultimediaid(idMultimedia): Observable<Multimedia>{

    return this.http.get<Multimedia>(`${this.urlEndPoint}/${idMultimedia}`)

  }

  create(multimedia: Multimedia) : Observable<Multimedia>{

    return this.http.post<Multimedia>(this.urlEndPoint, multimedia, {headers: this.httpHeaders})
  }

  update(multimedia: Multimedia): Observable<Multimedia>{
    return this.http.put<Multimedia>(`${this.urlEndPoint}/${multimedia.idMultimedia}`, multimedia, {headers: this.httpHeaders})
  }

  delete(id: number): Observable<Multimedia>{
    return this.http.delete<Multimedia>(`${this.urlEndPoint}/${id}`, {headers: this.httpHeaders})
  }




}
