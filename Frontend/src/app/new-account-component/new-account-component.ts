import { Component, OnInit } from '@angular/core';
import { BankAccountService } from '../../services/bank-account-service';
import { FormBuilder, FormsModule, ReactiveFormsModule, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-new-account-component',
  imports: [FormsModule, ReactiveFormsModule],
  templateUrl: './new-account-component.html',
  styleUrl: './new-account-component.css',
})
export class NewAccountComponent implements OnInit {
  constructor(private bankService: BankAccountService, private fb: FormBuilder) {}
  accountForm!: FormGroup;
  ngOnInit(): void {
    this.accountForm = this.fb.group({
      customerId: this.fb.control(''),
      initialBalance: this.fb.control(''),
      accountType: this.fb.control(''),
      accountStatus: this.fb.control(''),
      creationDate: this.fb.control(''),
    });
  }

  createAccount(): void {
    console.log("Account Created:", this.accountForm.value);
  }
}
