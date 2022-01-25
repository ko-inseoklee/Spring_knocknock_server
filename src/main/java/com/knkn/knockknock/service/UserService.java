package com.knkn.knockknock.service;

import com.knkn.knockknock.domain.User;
import com.knkn.knockknock.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findUsers(){
        return userRepository.findAll();
    }


    public boolean signUp(User user) {
        try{
            userRepository.save(user);

            return true;
        } catch (Exception e){
            e.printStackTrace();

            return  false;
        }
    }

    public boolean checkDuplicateID(String id){
        return userRepository.findByIdEquals(id).isPresent();
    }

    public boolean checkDuplicateNickName(String nickname){
        return userRepository.findByNicknameEquals(nickname).isPresent();
    }
}
