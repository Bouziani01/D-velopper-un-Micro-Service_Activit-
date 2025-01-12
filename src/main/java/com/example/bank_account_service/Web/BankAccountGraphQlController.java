package com.example.bank_account_service.Web;

import com.example.bank_account_service.Entities.BankAccount;
import com.example.bank_account_service.Entities.Customer;
import com.example.bank_account_service.Repositories.BankAccountRepository;
import com.example.bank_account_service.Repositories.CustomerRepository;
import com.example.bank_account_service.Service.AccountService;
import com.example.bank_account_service.dto.BankAccountRequestDTO;
import com.example.bank_account_service.dto.BankAccountResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQlController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
   @Autowired
   private CustomerRepository customerRepository;
    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
      return accountService.addAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDTO update(@Argument String id, @Argument BankAccountRequestDTO bankAccount){
        return accountService.updateAccount(id,bankAccount);
    }
    @MutationMapping
    public void deleteAccount(@Argument String id){
       bankAccountRepository.deleteById(id);
   }
   @QueryMapping
   public List<Customer> customers(){
        return customerRepository.findAll();
   }
}
