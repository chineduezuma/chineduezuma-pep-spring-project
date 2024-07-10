package com.example.service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountService {

    AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }



    public Account addNewAccount(Account newAccount){
        
        if(newAccount.getUsername() != "" && newAccount.getPassword().length() >= 4 && accountRepository.findAccountByUsername(newAccount.getUsername()) == null){
             return accountRepository.save(newAccount);
        }
        return null;
    }



    public Account verifyAccount(Account account){
        
        if(accountRepository.findAccountByUsernameAndPassword(account.getUsername(), account.getPassword()) != null ){
             return accountRepository.save(account);
        }
        return null;
    }

    

    
}
