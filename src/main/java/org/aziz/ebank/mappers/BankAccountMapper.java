package org.aziz.ebank.mappers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aziz.ebank.DTOs.BankAccountRequest;
import org.aziz.ebank.DTOs.BankAccountResponse;
import org.aziz.ebank.entities.BankAccount;
import org.aziz.ebank.entities.CurrentAccount;
import org.aziz.ebank.entities.SavingAccount;
import org.aziz.ebank.enums.AccountType;
import org.aziz.ebank.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor

public class BankAccountMapper {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    public BankAccountResponse toBankAccountResponse(BankAccount bankAccount) {
        return BankAccountResponse
                .builder()
                .Id(bankAccount.getId())
                .balance(bankAccount.getBalance())
                .createdAt(bankAccount.getCreatedAt())
                .status(bankAccount.getStatus())
                .customerId(bankAccount.getCustomer().getId())
                .extra(bankAccount instanceof CurrentAccount ?
                        ((CurrentAccount) bankAccount).getOverDraft() :
                        ((SavingAccount) bankAccount).getInterestRate()
                )
                .type(bankAccount instanceof CurrentAccount ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                .build();
    }

    public BankAccount fromBankAccountResponse(BankAccountResponse bankAccountResponse) {
        if(bankAccountResponse==null) return null;
        BankAccount bankAccount;
        if (bankAccountResponse.getType() == AccountType.CURRENT_ACCOUNT) {
            bankAccount = new CurrentAccount();
        } else {
            bankAccount = new SavingAccount();
        }
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setBalance(bankAccountResponse.getBalance());
        bankAccount.setCreatedAt(bankAccountResponse.getCreatedAt());
        bankAccount.setStatus(bankAccountResponse.getStatus());
        bankAccount.setCustomer(
                customerMapper.fromCustomerResponse(
                                customerService.getCustomerById(
                                                bankAccountResponse.getCustomerId()
                                        )
                        )
        );
        return bankAccount;
    }

    public BankAccount fromBankAccountRequest(BankAccountRequest bankAccountRequest) {
        if(bankAccountRequest==null) return null;
        BankAccount bankAccount;
        if (bankAccountRequest.getType() == AccountType.CURRENT_ACCOUNT) {
            bankAccount = new CurrentAccount();
            ((CurrentAccount) bankAccount).setOverDraft(
                    bankAccountRequest.getExtra()
            );
        } else {
            bankAccount = new SavingAccount();
            ((SavingAccount) bankAccount).setInterestRate(
                    bankAccountRequest.getExtra()
            );
        }
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setBalance(bankAccountRequest.getBalance());
        bankAccount.setStatus(bankAccountRequest.getStatus());
        bankAccount.setCreatedAt(bankAccountRequest.getCreatedAt());
        bankAccount.setCustomer(
                customerMapper.fromCustomerResponse(
                                customerService.getCustomerById(
                                                bankAccountRequest.getCustomerId()
                                        )
                        )
        );
        return bankAccount;
    }
}
