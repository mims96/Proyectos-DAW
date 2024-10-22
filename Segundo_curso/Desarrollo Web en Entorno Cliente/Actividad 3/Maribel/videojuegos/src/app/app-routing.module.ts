import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactoComponent } from './contacto/contacto.component';
import { AboutComponent } from './about/about.component';
import { IndexComponent } from './index/index.component';
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

/*En esta página va a constar el enrutamiento. Las líneas superiores son automáticamente generadas
cuando se crea el path que figura a continuación. O lo que es lo mismo, abajo se decide el nombre
de la url de cada página del proyecto.
Además, se especifica que por defecto al arrancar la app nos redirija al login.
*/

const routes: Routes = [
  {path: 'contacto', component: ContactoComponent},
  {path: 'about', component: AboutComponent},
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'index', component: IndexComponent },
  {path: 'login', component: LoginComponent},
  {path: 'videogame1/:id/:titulo/:compania/:valoracion', component: Videogame1Component},
  {path: 'videogame2/:id/:titulo/:compania/:valoracion', component: Videogame2Component},
  {path: 'videogame3/:id/:titulo/:compania/:valoracion', component: Videogame3Component},
  {path: 'videogame4/:id/:titulo/:compania/:valoracion', component: Videogame4Component},
  {path: 'videogame5/:id/:titulo/:compania/:valoracion', component: Videogame5Component},
  {path: 'videogame6/:id/:titulo/:compania/:valoracion', component: Videogame6Component},
  {path: 'videogame7/:id/:titulo/:compania/:valoracion', component: Videogame7Component},
  {path: 'videogame8/:id/:titulo/:compania/:valoracion', component: Videogame8Component},
  {path: 'videogame9/:id/:titulo/:compania/:valoracion', component: Videogame9Component},
  {path: 'videogame10/:id/:titulo/:compania/:valoracion', component: Videogame10Component}
  


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
