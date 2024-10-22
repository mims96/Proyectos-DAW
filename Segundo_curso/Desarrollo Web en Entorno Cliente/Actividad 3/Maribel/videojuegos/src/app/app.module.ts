import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
//Se debe importar lo siguiente para manejar mejor los formularios: 
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IndexComponent } from './index/index.component';
import { AboutComponent } from './about/about.component';
import { ContactoComponent } from './contacto/contacto.component';
import { LoginComponent } from './login/login.component';
import { Videogame1Component } from './videogame1/videogame1.component';
import { Videogame2Component } from './videogame2/videogame2.component';
import { Videogame3Component } from './videogame3/videogame3.component';
import { Videogame4Component } from './videogame4/videogame4.component';
import { Videogame5Component } from './videogame5/videogame5.component';
import { Videogame6Component } from './videogame6/videogame6.component';
import { Videogame7Component } from './videogame7/videogame7.component';
import { Videogame8Component } from './videogame8/videogame8.component';
import { Videogame9Component } from './videogame9/videogame9.component';
import { Videogame10Component } from './videogame10/videogame10.component';

@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    AboutComponent,
    ContactoComponent,
    LoginComponent,
    Videogame1Component,
    Videogame2Component,
    Videogame3Component,
    Videogame4Component,
    Videogame5Component,
    Videogame6Component,
    Videogame7Component,
    Videogame8Component,
    Videogame9Component,
    Videogame10Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
