import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Admin } from './book-store';
@Injectable({
  providedIn: 'root'
})
export class BookStoreService {

  baseUrl = "https://localhost:8080/bookstore/";

  constructor(private http:HttpClient) { }

  public editAdmin(adminId: number, admin: Admin){
    return this.http.put(this.baseUrl+"editAdmin/"+adminId,admin,{responseType:'text'});
  }
}
