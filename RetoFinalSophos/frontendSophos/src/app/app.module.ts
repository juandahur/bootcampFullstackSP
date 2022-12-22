import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ClientsListComponent } from './screens/clients-list/clients-list.component';
import { ClientsCreateComponent } from './screens/clients-create/clients-create.component';
import { ClientsEditComponent } from './screens/clients-edit/clients-edit.component';
import { ProductsListComponent } from './screens/products-list/products-list.component';
import { ProductsCreateComponent } from './screens/products-create/products-create.component';
import { TransactionsListComponent } from './screens/transactions-list/transactions-list.component';
import { TransactionsCreateComponent } from './screens/transactions-create/transactions-create.component';
import { HomeComponent } from './screens/home/home.component';
import { NavbarComponent } from './screens/navbar/navbar.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MenuComponent } from './screens/menu/menu.component';
import { ProductsClientComponent } from './screens/products-client/products-client.component';
import { TransactionsProductComponent } from './screens/transactions-product/transactions-product.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    ClientsListComponent,
    ClientsCreateComponent,
    ClientsEditComponent,
    ProductsListComponent,
    ProductsCreateComponent,
    TransactionsListComponent,
    TransactionsCreateComponent,
    HomeComponent,
    NavbarComponent,
    MenuComponent,
    ProductsClientComponent,
    TransactionsProductComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
