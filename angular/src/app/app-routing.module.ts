import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UtilisateurListComponent } from './utilisateur-list/utilisateur-list.component';
import { UtilisateurFormComponent } from './utilisateur-form/utilisateur-form.component';
 
const routes: Routes = [
  { path: 'utilisateurs', component: UtilisateurListComponent },
  { path: 'inscriptionUtilisateur', component: UtilisateurFormComponent }
];
 
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }