package org.elmekki.accountservice.clients;

import org.elmekki.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "CUSTMOR-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    Customer findCustomerById(@PathVariable Long id);
    @GetMapping("/customers")
    List<Customer> allCustomers();
}
