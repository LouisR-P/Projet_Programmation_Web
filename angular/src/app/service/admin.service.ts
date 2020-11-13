import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

const ADMIN_URL = 'http://localhost:8080/api/role/admin/';
 
@Injectable({
  providedIn: 'root'
})
export class AdminService {
 
  constructor(private http: HttpClient) { }

  utilisateurs(): Observable<any> {
    return this.http.get(ADMIN_URL + 'utilisateurs', { responseType: 'text' });
  }

}