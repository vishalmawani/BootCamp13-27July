import { BrowserModule } from '@angular/platform-browser';
import { FormsModule} from "@angular/forms";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EditAdminComponent } from './edit-admin/edit-admin.component';
import { HttpClientModule } from "@angular/common/http";
import { NgModule } from "@angular/core";
@NgModule({
  declarations: [
    AppComponent,
    EditAdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
