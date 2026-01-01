package org.aziz.ebank.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aziz.ebank.DTOs.OperationRequest;
import org.aziz.ebank.DTOs.OperationResponse;
import org.aziz.ebank.entities.Operation;
import org.aziz.ebank.mappers.OperationMapper;
import org.aziz.ebank.repositories.OperationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService{

    private final OperationRepository operationRepository;
    private final OperationMapper operationMapper;

    @Override
    public List<OperationResponse> getAllOperations() {
        return operationRepository
                .findAll()
                .stream()
                .map(operationMapper::toOperationResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OperationResponse saveOperation(OperationRequest operationRequest) {
        Operation operation = operationRepository.save(operationMapper.fromOperationRequest(operationRequest));
        return operationMapper.toOperationResponse(operation);
    }
}
