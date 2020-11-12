import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UtilisateurService } from '../service/utilisateur.service';
import { Utilisateur } from '../model/utilisateur';
 
@Component({
  selector: 'app-utilisateur-form',
  templateUrl: './utilisateur-form.component.html',
  styleUrls: ['./utilisateur-form.component.css']
})
export class UtilisateurFormComponent {
 
  utilisateur: Utilisateur;
 
  constructor(
    private route: ActivatedRoute, 
      private router: Router, 
        private utilisateurService: UtilisateurService) {
    this.utilisateur = new Utilisateur();
  }
 
  onSubmit() {
    this.utilisateurService.save(this.utilisateur).subscribe(result => this.gotoUtilisateurList());
  }
 
  gotoUtilisateurList() {
    this.router.navigate(['/utilisateurs']);
  }
}