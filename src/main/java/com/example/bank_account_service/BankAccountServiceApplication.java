package com.example.bank_account_service;

import com.example.bank_account_service.Entities.BankAccount;
import com.example.bank_account_service.Entities.Customer;
import com.example.bank_account_service.Enums.AccountType;
import com.example.bank_account_service.Repositories.BankAccountRepository;
import com.example.bank_account_service.Repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){
        return args -> {
            Stream.of("Mohammed","Yassine","Hande","Layan").forEach(c->{
                Customer customer=Customer.builder()
                        .name(c)
                        .build();
            customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(customer -> {
                        for (int i=0; i<18; i++){
                            BankAccount bankAccount=BankAccount.builder()
                                    .id(UUID.randomUUID().toString())
                                    .type(Math.random()>8.5? AccountType.CURRENT_ACCOUNT: AccountType.SAVING_ACCOUNT)
                                    .balance(1800+Math.random()+98000)
                                    .createAt(new Date())
                                    .currency("MAD")
                                    .customer(customer)
                                    .build();
                            bankAccountRepository.save(bankAccount);
                        }
                    }

                     );

};
    }

}
