package org.aziz.ebank.services;

import org.aziz.ebank.DTOs.CustomerRequest;
import org.aziz.ebank.DTOs.CustomerResponse;

import java.util.List;

public interface CustomerService {

    public CustomerResponse saveCustomer(CustomerRequest customer);
    public void DeleteCustomerById(Long customerId);
    public CustomerResponse getCustomerById(Long customerId);
    public List<CustomerResponse> getAllCustomers();

    List<CustomerResponse> searchCustomers(String keyword);

    CustomerResponse createCustomer(CustomerRequest customerRequest);
}
