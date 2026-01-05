import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../environments/environment.development';
import { Observable } from 'rxjs';
import { Customer } from '../models/customer.model';
import { CustomerRequest } from '../models/customerRequest';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  constructor(private http: HttpClient) {}

  getAllCustomers(): Observable<Array<Customer>> {
    return this.http.get<Array<Customer>>(environment.BACKEND_BASE_URL + '/api/customers');
  }
  filterCustomers(keyword: string): Observable<Array<Customer>> {
    return this.http.get<Array<Customer>>(`${environment.BACKEND_BASE_URL}/api/customers/search?keyword=${keyword}`);
  }
  createCustomer(customerRequest: CustomerRequest): Observable<Customer> {
    return this.http.post<Customer>(`${environment.BACKEND_BASE_URL}/api/customers`, customerRequest);
  }

  deleteCustomer(id: number): Observable<void> {
    return this.http.delete<void>(`${environment.BACKEND_BASE_URL}/api/customers/${id}`);
  }
}
