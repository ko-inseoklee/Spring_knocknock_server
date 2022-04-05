package com.knkn.knockknock.repository.userRepository;

import com.knkn.knockknock.domain.user.Confirm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Repository
public interface ConfirmRepository extends JpaRepository<Confirm, Long> {
    Confirm findByPhoneNumberEquals(String phoneNumber);

    @Transactional
    @Modifying
    @Query("update Confirm c set c.validationNumber = ?1, c.requestTime = ?2, c.creationTime = ?3 " +
            "where c.phoneNumber = ?4")
    void updateValidation(String validationNumber, int requestTime, Timestamp creationTime, String phoneNumber);






}