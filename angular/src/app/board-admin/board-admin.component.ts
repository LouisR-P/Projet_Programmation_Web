import { Component, OnInit } from '@angular/core';
import { RoleService } from '../service/role.service';
import { AdminService } from "../service/admin.service";

@Component({
  selector: 'app-board-admin',
  templateUrl: './board-admin.component.html',
  styleUrls: ['./board-admin.component.css']
})
export class BoardAdminComponent implements OnInit {

  content: string;
  utilisateurs: string;

  constructor(private roleService: RoleService, private adminService: AdminService) { }

  ngOnInit(): void {
    this.roleService.getAdminBoard().subscribe(
      data => {
        this.content = data;
      },
      err => {
        this.content = JSON.parse(err.error).message;
      },
    ) 
    this.adminService.utilisateurs().subscribe(
        data => {
          this.utilisateurs = data;
        },
        err => {
          this.content = JSON.parse(err.error).message;
        }
      );
  }

}
