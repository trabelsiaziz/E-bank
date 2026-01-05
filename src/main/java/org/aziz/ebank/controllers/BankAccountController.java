package org.aziz.ebank.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aziz.ebank.DTOs.BankAccountRequest;
import org.aziz.ebank.DTOs.BankAccountResponse;
import org.aziz.ebank.services.BankAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/BankAccounts")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @GetMapping("health")
    public String healthCheck() {
        return "BankAccount Service is up and running!";
    }

    @GetMapping
    public ResponseEntity<List<BankAccountResponse>> getAllBankAccounts() {
        return ResponseEntity.ok(bankAccountService.getAllBankAccounts());
    }


    @PostMapping
    public ResponseEntity<BankAccountResponse> createBankAccount(
            @RequestBody BankAccountRequest bankAccountRequest
    ) {
        BankAccountResponse createdAccount = bankAccountService.createBankAccount(bankAccountRequest);
        return ResponseEntity.ok(createdAccount);
    }


}
