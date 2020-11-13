import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const AUTH_API = 'http://localhost:8080/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(credentials): Observable<any> {
    return this.http.post(AUTH_API + 'signin', {
      nom: credentials.nom,
      motDePasse: credentials.motDePasse
    }, httpOptions);
  }

  register(utilisateur): Observable<any> {
    return this.http.post(AUTH_API + 'signup', {
      email: utilisateur.email,
      motDePasse: utilisateur.motDePasse,
      nom: utilisateur.nom,
      prenom: utilisateur.prenom,
      numero: utilisateur.numero,
      licence: utilisateur.licence
    }, httpOptions);
  }
}
