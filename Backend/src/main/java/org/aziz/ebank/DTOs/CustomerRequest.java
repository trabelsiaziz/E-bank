package org.aziz.ebank.DTOs;



import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class CustomerRequest {

    private String name;
    private String email;

}
