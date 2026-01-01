package org.aziz.ebank.mappers;


import lombok.extern.slf4j.Slf4j;
import org.aziz.ebank.DTOs.CustomerRequest;
import org.aziz.ebank.DTOs.CustomerResponse;
import org.aziz.ebank.entities.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerMapper {


    public Customer fromCustomerRequest(CustomerRequest customerRequest) {
        if(customerRequest == null) {
            log.error("CustomerRequest is null in CustomerMapper.fromCustomerRequest");
            return null;
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerRequest, customer);
        return customer;
    }


    public CustomerResponse toCustomerResponse(Customer customer) {
        if (customer == null) {
            log.error("Customer is null in CustomerMapper.toCustomerResponse");
            return null;
        }
        CustomerResponse customerResponse = new CustomerResponse();
        BeanUtils.copyProperties(customer, customerResponse);
        return customerResponse;
    }

    public Customer fromCustomerResponse(CustomerResponse customerResponse) {
        if (customerResponse == null) {
            log.error("CustomerResponse is null in CustomerMapper.fromCustomerResponse");
            return null;
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerResponse, customer);
        return customer;
    }




}
