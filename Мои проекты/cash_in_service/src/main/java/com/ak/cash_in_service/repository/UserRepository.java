package com.ak.cash_in_service.repository;

import com.ak.cash_in_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Abubakir Dev
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from User u where u.phoneNumber = :phoneNumber")
    Optional<User> findUserByPhoneNumber(String phoneNumber);

    Optional<User> getUserByEmail(String email);

    boolean existsByEmail(String email);
}
