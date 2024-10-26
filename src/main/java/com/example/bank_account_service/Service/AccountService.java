package com.example.bank_account_service.Service;

import com.example.bank_account_service.Entities.BankAccount;
import com.example.bank_account_service.dto.BankAccountRequestDTO;
import com.example.bank_account_service.dto.BankAccountResponseDTO;

public interface AccountService {
     BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
     BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
