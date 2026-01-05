import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CustomerService } from '../../services/customer-service';
import { CustomerRequest } from '../../models/customerRequest.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-customer-component',
  imports: [FormsModule, ReactiveFormsModule],
  templateUrl: './new-customer-component.html',
  styleUrl: './new-customer-component.css',
})
export class NewCustomerComponent implements OnInit {
  constructor(private fb: FormBuilder, private customerService: CustomerService, private router: Router) {}
  customerForm!: FormGroup;
  ngOnInit(): void {
    this.customerForm = this.fb.group({
      name: this.fb.control(''),
      email: this.fb.control(''),
    });
  }

  createCustomer(): void {
    const customerRequest: CustomerRequest = {
      name: this.customerForm.value.name,
      email: this.customerForm.value.email,
    };
    console.log(customerRequest);
    this.customerService.createCustomer(customerRequest).subscribe({
      next: (customer) => {
        console.log('Customer created successfully:', customer);
        this.router.navigateByUrl('/customers');
      },
      error: (error) => {
        console.error('Error creating customer:', error);
      },
    });
  }
}

