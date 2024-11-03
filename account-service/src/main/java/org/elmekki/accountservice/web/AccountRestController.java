package org.elmekki.accountservice.web;

import org.elmekki.accountservice.clients.CustomerRestClient;
import org.elmekki.accountservice.entities.BankAccount;
import org.elmekki.accountservice.model.Customer;
import org.elmekki.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private BankAccountRepository accountRepository;
    private CustomerRestClient customerRestClient;


    public AccountRestController(CustomerRestClient customerRestClient, BankAccountRepository accountRepository) {
        this.customerRestClient = customerRestClient;
        this.accountRepository = accountRepository;
    }

    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
        return accountRepository.findAll();

    }
    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id){
        BankAccount bankAccount = accountRepository.findById(id).get();
        Customer customer=customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }

}
