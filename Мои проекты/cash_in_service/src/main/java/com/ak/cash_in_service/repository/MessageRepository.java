package com.ak.cash_in_service.repository;

import com.ak.cash_in_service.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Abubakir Dev
 */
@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
}
