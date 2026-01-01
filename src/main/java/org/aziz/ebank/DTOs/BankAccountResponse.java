package org.aziz.ebank.DTOs;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.aziz.ebank.enums.AccountStatus;
import org.aziz.ebank.enums.AccountType;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BankAccountResponse {

    private String Id;
    private double balance;
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    private Long customerId;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    private double extra;
}
