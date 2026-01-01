package org.aziz.ebank.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@DiscriminatorValue(value = "CA")


public class CurrentAccount extends BankAccount{
    private double overDraft;

}
