import { Component, OnInit } from '@angular/core';
import { Utilisateur } from '../model/utilisateur';
import { UtilisateurService } from '../service/utilisateur.service';
 
@Component({
  selector: 'app-utilisateur-list',
  templateUrl: './utilisateur-list.component.html',
  styleUrls: ['./utilisateur-list.component.css']
})
export class UtilisateurListComponent implements OnInit {
 
  utilisateurs: Utilisateur[];
 
  constructor(private utilisateurService: UtilisateurService) {
  }
 
  ngOnInit() {
    this.utilisateurService.findAll().subscribe(data => {
      this.utilisateurs = data;
    });
  }
}