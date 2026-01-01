package org.aziz.ebank.services;

import org.aziz.ebank.DTOs.BankAccountRequest;
import org.aziz.ebank.DTOs.BankAccountResponse;
import org.aziz.ebank.entities.BankAccount;

import java.util.List;

public interface BankAccountService {
    public BankAccountResponse saveBankAccount(BankAccountRequest bankAccountRequest);
    public Void deleteBankAccountById(String id);
    public List<BankAccountResponse>getAllBankAccounts();
    public BankAccountResponse getBankAccountById(String id);
}
