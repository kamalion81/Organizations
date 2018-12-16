import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { RestangularModule } from 'ngx-restangular';
import { OrganizationsComponent } from './organizations/organizations.component';

export function RestangularConfigFactory (RestangularProvider) {
  RestangularProvider.setBaseUrl('http://localhost:8080');
}

@NgModule({
  declarations: [
    AppComponent,
    OrganizationsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RestangularModule.forRoot(RestangularConfigFactory)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
