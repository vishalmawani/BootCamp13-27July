import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EditAdminComponent } from './edit-admin/edit-admin.component';

const routes: Routes = [
  {path:'editAdmin', component:EditAdminComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
