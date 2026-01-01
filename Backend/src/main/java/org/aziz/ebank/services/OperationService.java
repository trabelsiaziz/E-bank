package org.aziz.ebank.services;


import org.aziz.ebank.DTOs.OperationRequest;
import org.aziz.ebank.DTOs.OperationResponse;

import java.util.List;

public interface OperationService {
    public OperationResponse saveOperation(OperationRequest operationRequest);
    public List<OperationResponse> getAllOperations();
}
