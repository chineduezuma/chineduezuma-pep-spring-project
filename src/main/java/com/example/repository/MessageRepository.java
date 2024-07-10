package com.example.repository;

import com.example.entity.Message;
import com.example.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    @Query("FROM Account WHERE accountId = :accountId")
    Account getAccountByAccountId(@Param("accountId") Integer accountId);
    
    @Query("FROM Message WHERE postedBy = :accountId")
    List<Message> getAllMessagesByAccountId(@Param("accountId") Integer accountId);
    
}
