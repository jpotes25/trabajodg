import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgxYoutubePlayerModule } from 'ngx-youtube-player';
import { AppComponent } from './app.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import {RouterModule, Routes} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import { DificultadComponent } from './dificultad/dificultad.component';
import {DificultadService} from './dificultad/dificultad.service';
import {MultimediaService} from './multimediadif/multimedia.service';
import {ActividadesService} from './actividades/actividades.service';
import {ReferenteService} from './referentes/referentes.service';
import { ComoidentifComponent } from './comoidentif/comoidentif.component';
import { AdministradorComponent } from './administrador/administrador.component';
import {FormsModule} from '@angular/forms';
import { FormComponent } from './administrador/form.component';
import { MultimediadifComponent } from './multimediadif/multimediadif.component';
import { AdminmultimediaComponent } from './administrador/adminmultimedia/adminmultimedia.component';
import { FormmultimediaComponent } from './administrador/adminmultimedia/formmultimedia.component';
import { ActividadesComponent } from './actividades/actividades.component';
import { AdminactividadesComponent } from './administrador/adminActividades/adminactividades.component';
import { FormactividadesComponent } from './administrador/adminactividades/formactividades.component';
import { ReferentesComponent } from './referentes/referentes.component';
import { AdminreferentesComponent } from './administrador/adminReferentes/adminreferentes.component';
import { FormreferentesComponent } from './administrador/adminreferentes/formreferentes.component';
import { ConozcanosComponent } from './conozcanos/conozcanos.component'

const routes: Routes =
[
{path: '', component: HomeComponent},
{path: 'dificultad/:id', component: DificultadComponent},
{path: 'comoIdentificarla/:id', component: ComoidentifComponent},
{path: 'administrador/form', component: FormComponent},
{path: 'administrador', component:AdministradorComponent},
{path: 'administrador/form/:id', component: FormComponent},
{path: 'multimediadif/:id', component: MultimediadifComponent},
{path: 'adminMultimedia', component: AdminmultimediaComponent},
{path: 'adminMultimedia/form/:id', component: FormmultimediaComponent},
{path: 'adminMultimedia/form', component: FormmultimediaComponent},
{path: 'actividades/:id', component: ActividadesComponent},
{path: 'adminActividades', component: AdminactividadesComponent},
{path: 'adminActividades/form/:id', component: FormactividadesComponent},
{path: 'adminActividades/form', component: FormactividadesComponent},
{path: 'referentes/:id', component: ReferentesComponent},
{path: 'adminReferentes', component: AdminreferentesComponent},
{path: 'adminReferentes/form/:id', component: FormreferentesComponent},
{path: 'adminReferentes/form', component: FormreferentesComponent},
{path: 'conozcanos', component: ConozcanosComponent}

]

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HomeComponent,
    DificultadComponent,
    ComoidentifComponent,
    AdministradorComponent,
    FormComponent,
    MultimediadifComponent,
    AdminmultimediaComponent,
    FormmultimediaComponent,
    ActividadesComponent,
    AdminactividadesComponent,
    FormactividadesComponent,
    ReferentesComponent,
    AdminreferentesComponent,
    FormreferentesComponent,
    ConozcanosComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    NgxYoutubePlayerModule.forRoot(),
    FormsModule,
    RouterModule.forRoot(routes),

  ],
  exports: [
  RouterModule
  ],
  providers: [DificultadService, MultimediaService, ActividadesService, ReferenteService],
  bootstrap: [AppComponent]
})
export class AppModule { }
