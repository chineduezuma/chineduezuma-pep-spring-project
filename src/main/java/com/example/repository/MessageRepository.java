package com.example.repository;

import com.example.entity.Message;
import com.example.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    @Query("FROM Account WHERE accountId = :accountId")
    Account findAccountByAccountId(@Param("accountId") Integer accountId);
    

    
    @Query("FROM Message WHERE messageId = :messageId")
    Message findMessageByMessageId(@Param("messageId") Integer messageId);
    
    
    
    @Query("FROM Message WHERE postedBy = :accountId")
    List<Message> findAllMessagesByPostedBy(@Param("accountId") Integer accountId);

    
    
}
