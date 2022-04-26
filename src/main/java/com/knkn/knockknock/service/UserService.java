package com.knkn.knockknock.service;

import com.knkn.knockknock.KnKnUtility;
import com.knkn.knockknock.domain.user.Confirm;
import com.knkn.knockknock.domain.user.User;
import com.knkn.knockknock.repository.userRepository.UserRepository;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ConfirmService confirmService;

    public UserService(UserRepository userRepository, ConfirmService confirmService) {
        this.userRepository = userRepository;
        this.confirmService = confirmService;
    }

    public List<User> findUsers(){
        return userRepository.findAll();
    }

    public User currentUser(String id){
        Optional<User> result = userRepository.findByIdEquals(id);
        return result.isPresent() ? result.get() : result.orElse(null);
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

    public void sendAuthMessage(String phoneNumber) throws CoolsmsException {
        try{
            String code = KnKnUtility.generateIdentifyNumber();
            confirmService.sendMessage(phoneNumber, code);
            Confirm confirm = new Confirm();
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public boolean validatePhoneAuth(String phoneNumber, String code){
        return confirmService.checkValidation(phoneNumber, code);
    }
}
