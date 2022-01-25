package com.knkn.knockknock.service;

import com.knkn.knockknock.domain.User;
import com.knkn.knockknock.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void signUp(User user) {
        userRepository.save(user);
    }

    public Optional<User> findById(String id){
        return userRepository.findByIdEquals(id);
    }

    public boolean checkDuplicateID(String id){
        return  userRepository.findByIdEquals(id).isPresent();
    }
}
