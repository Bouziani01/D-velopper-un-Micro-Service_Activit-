package com.example.bank_account_service.Entities;

import com.example.bank_account_service.Enums.AccountType;
import org.springframework.data.rest.core.config.Projection;
@Projection(types=BankAccount.class, name = "p1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();

}
