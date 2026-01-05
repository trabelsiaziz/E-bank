import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../environments/environment.development';
import { Observable } from 'rxjs';
import { CustomerResponse } from '../models/customerResponse.model';
import { CustomerRequest } from '../models/customerRequest.model';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  constructor(private http: HttpClient) {}

  getAllCustomers(): Observable<Array<CustomerResponse>> {
    return this.http.get<Array<CustomerResponse>>(environment.BACKEND_BASE_URL + '/api/customers');
  }
  filterCustomers(keyword: string): Observable<Array<CustomerResponse>> {
    return this.http.get<Array<CustomerResponse>>(`${environment.BACKEND_BASE_URL}/api/customers/search?keyword=${keyword}`);
  }
  createCustomer(customerRequest: CustomerRequest): Observable<CustomerResponse> {
    return this.http.post<CustomerResponse>(`${environment.BACKEND_BASE_URL}/api/customers`, customerRequest);
  }

  deleteCustomer(id: number): Observable<void> {
    return this.http.delete<void>(`${environment.BACKEND_BASE_URL}/api/customers/${id}`);
  }
}
