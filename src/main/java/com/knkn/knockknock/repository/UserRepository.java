package com.knkn.knockknock.repository;

import com.knkn.knockknock.domain.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByIdEquals(@NonNull String id);
    Optional<User> findByNicknameEquals(String nickname);

    @Override
    <S extends User> List<S> findAll(Example<S> example);
}