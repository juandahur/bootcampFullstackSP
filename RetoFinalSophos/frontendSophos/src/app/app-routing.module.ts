import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientsCreateComponent } from './screens/clients-create/clients-create.component';
import { ClientsEditComponent } from './screens/clients-edit/clients-edit.component';
import { ClientsListComponent } from './screens/clients-list/clients-list.component';
import { HomeComponent } from './screens/home/home.component';
import { MenuComponent } from './screens/menu/menu.component';
import { ProductsClientComponent } from './screens/products-client/products-client.component';
import { ProductsCreateComponent } from './screens/products-create/products-create.component';
import { ProductsListComponent } from './screens/products-list/products-list.component';
import { TransactionsCreateComponent } from './screens/transactions-create/transactions-create.component';
import { TransactionsListComponent } from './screens/transactions-list/transactions-list.component';
import { TransactionsProductComponent } from './screens/transactions-product/transactions-product.component';

const routes: Routes = [
  { path: 'menu', component: MenuComponent },
  { path: 'clients', component: ClientsListComponent },
  { path: 'clients-create', component: ClientsCreateComponent },
  { path: 'clients-edit/:id', component: ClientsEditComponent },
  { path: 'products', component: ProductsListComponent },
  { path: 'products/:id', component: ProductsClientComponent },
  { path: 'products-create/:id', component: ProductsCreateComponent },
  { path: 'transactions', component: TransactionsListComponent },
  { path: 'transactions/:id', component: TransactionsProductComponent },
  { path: 'transactions-create/:id', component: TransactionsCreateComponent },
  { path: 'home', component: HomeComponent },
  { path: '', component: HomeComponent },
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
