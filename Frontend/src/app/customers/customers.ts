import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../../services/customer-service';
import { catchError, EMPTY, Observable } from 'rxjs';
import { AsyncPipe, CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CustomerResponse } from '../../models/customerResponse.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customers',
  imports: [CommonModule, AsyncPipe, FormsModule],
  templateUrl: './customers.html',
  styleUrl: './customers.css',
})
export class Customers implements OnInit {
  columns: String[] = ['Id', 'Name', 'Email'];
  data$!: Observable<Array<CustomerResponse>>;
  errorMessage: string | null = null;
  keyword: string = '';

  constructor(private customerservice: CustomerService, private router: Router) {}

  ngOnInit(): void {
    this.getAllCustomers();
  }

  getAllCustomers(): void {
    this.data$ = this.customerservice.getAllCustomers().pipe(
      catchError((error) => {
        this.errorMessage = error.message;
        return EMPTY;
      })
    );
  }

  filterCustomers(): void {
    this.data$ = this.customerservice.filterCustomers(this.keyword).pipe(
      catchError((error) => {
        this.errorMessage = error.message;
        return EMPTY;
      })
    );
  }

  deleteCustomer(id: number): void {
    this.customerservice.deleteCustomer(id).subscribe({
      next: () => {
        this.getAllCustomers();
      },
      error: (error) => {
        console.error('Error deleting customer:', error);
      },
    });
  }

  trackById(index: number, item: any) {
    return item.id;
  }
}
