package org.aziz.ebank;

import lombok.extern.slf4j.Slf4j;
import org.aziz.ebank.DTOs.BankAccountRequest;
import org.aziz.ebank.DTOs.CustomerRequest;
import org.aziz.ebank.enums.AccountStatus;
import org.aziz.ebank.enums.AccountType;
import org.aziz.ebank.services.BankAccountService;
import org.aziz.ebank.services.CustomerService;
import org.aziz.ebank.services.OperationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@Slf4j
public class EBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(EBankApplication.class, args);
    }

    String[] names = {"Aziz", "Mohamed", "Ali", "Youssef", "Sara", "Lina", "Omar", "Nadia", "Hassan", "Mona"};

    @Bean
    CommandLineRunner commandLineRunner(
            CustomerService customerService,
            BankAccountService bankAccountService,
            OperationService operationService
    ){
        return args -> {
            for(String name: names){
                customerService.saveCustomer(
                        CustomerRequest
                                .builder()
                                .name(name)
                                .email(name + "@gmail.com")
                                .build()
                );

            }

            customerService
                    .getAllCustomers()
                    .forEach(
                            customerResponse -> {
                                BankAccountRequest x = BankAccountRequest
                                        .builder()
                                        .type(AccountType.SAVING_ACCOUNT)
                                        .balance(Math.random()*10000)
                                        .status(AccountStatus.CREATED)
                                        .createdAt(new Date())
                                        .customerId(customerResponse.getId())
                                        .extra(Math.random()*900)
                                        .build();
                                bankAccountService.saveBankAccount(x);
                                BankAccountRequest y = BankAccountRequest
                                        .builder()
                                        .type(AccountType.CURRENT_ACCOUNT)
                                        .status(AccountStatus.CREATED)
                                        .createdAt(new Date())
                                        .balance(Math.random()*10000)
                                        .customerId(customerResponse.getId())
                                        .extra(Math.random()*900)
                                        .build();
                                bankAccountService.saveBankAccount(y);
                            }
                    );

        };
    }


}
