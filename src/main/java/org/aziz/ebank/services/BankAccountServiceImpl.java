package org.aziz.ebank.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aziz.ebank.DTOs.BankAccountRequest;
import org.aziz.ebank.DTOs.BankAccountResponse;
import org.aziz.ebank.mappers.BankAccountMapper;
import org.aziz.ebank.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class BankAccountServiceImpl implements BankAccountService{

    private final BankAccountRepository bankAccountRepository;
    private final BankAccountMapper bankAccountMapper;

    @Override
    public BankAccountResponse saveBankAccount(BankAccountRequest bankAccountRequest) {

        bankAccountRepository.save(
                bankAccountMapper.fromBankAccountRequest(bankAccountRequest)
        );
        return bankAccountMapper.toBankAccountResponse(
                bankAccountMapper.fromBankAccountRequest(bankAccountRequest)
        );
    }

    @Override
    public Void deleteBankAccountById(String id) {
        return null;
    }

    @Override
    public List<BankAccountResponse> getAllBankAccounts() {
        return bankAccountRepository
                .findAll()
                .stream()
                .map(bankAccountMapper::toBankAccountResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BankAccountResponse getBankAccountById(String id) {
        return bankAccountMapper.toBankAccountResponse(
                bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException("Bank account not found"))
        );
    }

}
