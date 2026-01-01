package org.aziz.ebank.mappers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aziz.ebank.DTOs.OperationRequest;
import org.aziz.ebank.DTOs.OperationResponse;
import org.aziz.ebank.entities.Operation;
import org.aziz.ebank.services.BankAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OperationMapper {

    private final BankAccountService bankAccountService;
    private final BankAccountMapper bankAccountMapper;

    public Operation fromOperationRequest(OperationRequest operationRequest) {
        Operation operation = new Operation();
        BeanUtils.copyProperties(operationRequest, operation);
        operation.setBankAccount(bankAccountMapper
                .fromBankAccountResponse(
                        bankAccountService
                                .getBankAccountById(
                                        operationRequest
                                                .getBankAccountId()
                                )
                )
        );
        return operation;
    }

    public OperationResponse toOperationResponse(Operation operation) {
        if (operation != null) {
            OperationResponse operationResponse = new OperationResponse();
            BeanUtils.copyProperties(operation, operationResponse);
            operationResponse.setBankAccountId(operation.getBankAccount().getId());
            return operationResponse;
        }
        return null;
    }
}
