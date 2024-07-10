package com.example.repository;

import com.example.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("FROM Account WHERE username = :username")
    Account findAccountByUsername(@Param("username") String username);
}
