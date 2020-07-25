import { Component, OnInit } from '@angular/core';
import { Admin } from "../book-store";
import { BookStoreService } from "../book-store.service";
import { ActivatedRoute, Router } from '@angular/router';
import { error } from '@angular/compiler/src/util';

@Component({
  selector: 'app-edit-admin',
  templateUrl: './edit-admin.component.html',
  styleUrls: ['./edit-admin.component.css']
})
export class EditAdminComponent implements OnInit {

  info: string;
  errorInfo: string;
  adminId: number;
  email: string;
  admin: Admin = new Admin();

  constructor(private bookStoreService: BookStoreService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.adminId = this.route.snapshot.params['adminId'];
    this.email = this.route.snapshot.params['email'];
  }

  editAdmin(){
    this.bookStoreService.editAdmin(this.adminId, this.admin).subscribe((data)=>{
      console.log(data);
      this.info = data;
      alert(data);
    },
    error=>{
      this.info = undefined;
      this.errorInfo = error.error;
      console.log(this.errorInfo);
      alert("Admin not Found");
      
    })

    

  }

}
