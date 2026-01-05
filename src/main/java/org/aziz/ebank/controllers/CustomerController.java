package org.aziz.ebank.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aziz.ebank.DTOs.CustomerRequest;
import org.aziz.ebank.DTOs.CustomerResponse;
import org.aziz.ebank.repositories.CustomerRepository;
import org.aziz.ebank.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    @GetMapping("/health")
    public String healthCheck() {

        return "Customer Service is up and running!";
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(
            @RequestBody CustomerRequest customerRequest
    ){
        log.info("creating of new customer !!!!");
        return ResponseEntity.ok(customerService.createCustomer(customerRequest));

    }



    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> getCustomer(
            @PathVariable Long customerId
    ) {
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<CustomerResponse>> searchCustomers(
            @RequestParam(name = "keyword", defaultValue = "") String keyword
    ) {
        return ResponseEntity.ok(customerService.searchCustomers(keyword));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(
            @PathVariable Long customerId
    ) {
        log.info("deleting customer with ID::" + customerId);
        customerService.DeleteCustomerById(customerId);
        return ResponseEntity.ok().build();
    }



}
