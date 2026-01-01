package org.aziz.ebank.entities;


import jakarta.persistence.*;
import lombok.*;
import org.aziz.ebank.enums.OpertaionType;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity

public class Operation {
    @Id
    Long id;
    private Date operationDate;
    private double amount;
    private String description;
    @Enumerated(EnumType.STRING)
    private OpertaionType type;
    @ManyToOne
    private BankAccount bankAccount;
}
