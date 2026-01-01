package org.aziz.ebank.services;

import lombok.RequiredArgsConstructor;

import org.aziz.ebank.DTOs.CustomerRequest;
import org.aziz.ebank.DTOs.CustomerResponse;
import org.aziz.ebank.entities.Customer;
import org.aziz.ebank.mappers.CustomerMapper;
import org.aziz.ebank.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponse saveCustomer(CustomerRequest customerRequest) {
         Customer customer = customerRepository.save(customerMapper.fromCustomerRequest(customerRequest));
         return customerMapper.toCustomerResponse(customer);
    }

    @Override
    public void DeleteCustomerById(Long customerId) {

    }

    @Override
    public CustomerResponse getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        return customerMapper.toCustomerResponse(customer);
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        return customerRepository
                .findAll()
                .stream()
                .map(customerMapper::toCustomerResponse)
                .collect(Collectors.toList());
    }
}
