import { Routes } from '@angular/router';
import { Customers } from './customers/customers';
import { Accounts } from './accounts/accounts';
import { NewCustomerComponent } from './new-customer-component/new-customer-component';
import { NewAccountComponent } from './new-account-component/new-account-component';

export const routes: Routes = [
    {path: 'customers', component: Customers},
    {path: 'accounts', component: Accounts},
    {path: 'create/customer', component: NewCustomerComponent},
    {path: 'create/account', component: NewAccountComponent}
];
