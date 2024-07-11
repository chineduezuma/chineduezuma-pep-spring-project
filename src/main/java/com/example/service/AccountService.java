package com.example.service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
// @Transactional
public class AccountService {

    AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }


     /**
     * This method will persist an account to the Account database table, the equivalent of a
     * "insert into account" statement.
     * @return
     */
    public Account addNewAccount(Account newAccount){
        
        if(newAccount.getUsername() != "" && newAccount.getPassword().length() >= 4 && accountRepository.findAccountByUsername(newAccount.getUsername()) == null){
             return accountRepository.save(newAccount);
        }
        return null;
    }



    public Account existingUserAccount(Account newAccount){
        
        if(accountRepository.findAccountByUsername(newAccount.getUsername()) != null){
             return accountRepository.findAccountByUsername(newAccount.getUsername());
        }
        return null;
    }



    
    public Account verifyAccount(Account account){
        
        if(accountRepository.findAccountByUsernameAndPassword(account.getUsername(), account.getPassword()) != null ){
             return accountRepository.findAccountByUsernameAndPassword(account.getUsername(), account.getPassword());
        }
        return null;
    }

    

    
}
