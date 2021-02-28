import {Injectable} from '@angular/core';
import {REFERENTE} from './referentes.json';
import {Referentes} from './referentes';
import {of, Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable()
export class ReferenteService {
  private urlEndPoint: string = 'http://localhost:8080/api/referentes';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient){ }
  getReferente(): Observable<Referentes[]>{
    return this.http.get<Referentes[]>(this.urlEndPoint)
  }
  getReferenteid(idReferente): Observable<Referentes>{
    return this.http.get<Referentes>(`${this.urlEndPoint}/${idReferente}`)
  }
  create(referente: Referentes): Observable<Referentes>{
    return this.http.post<Referentes>(this.urlEndPoint, referente, {headers: this.httpHeaders})
  }
  update(referente: Referentes): Observable<Referentes>{
    return this.http.put<Referentes>(`${this.urlEndPoint}/${referente.idReferente}`, referente, {headers: this.httpHeaders})
  }
  delete(id: number): Observable<Referentes>{
    return this.http.delete<Referentes>(`${this.urlEndPoint}/${id}`, {headers: this.httpHeaders})
  }
}
