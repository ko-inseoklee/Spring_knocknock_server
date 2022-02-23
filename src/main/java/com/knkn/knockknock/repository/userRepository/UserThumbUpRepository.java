package com.knkn.knockknock.repository.userRepository;

import com.knkn.knockknock.domain.user.UserThumbUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserThumbUpRepository extends JpaRepository<UserThumbUp, Long> {
    Optional<UserThumbUp> findByUIdEqualsAndBIdEquals(String UId, Long BId);

    Optional<UserThumbUp> findByUIdEqualsAndCIdEquals(String UId, Long CId);
}