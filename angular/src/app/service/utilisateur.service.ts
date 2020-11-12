import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Utilisateur } from '../model/utilisateur';
import { Observable } from 'rxjs';
 
@Injectable()
export class UtilisateurService {
 
  private utilisateursUrl: string;
 
  constructor(private http: HttpClient) {
    this.utilisateursUrl = 'http://localhost:8080/utilisateurs';
  }
 
  public findAll(): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(this.utilisateursUrl);
  }
 
  public save(utilisateur: Utilisateur) {
    return this.http.post<Utilisateur>(this.utilisateursUrl, utilisateur);
  }
}