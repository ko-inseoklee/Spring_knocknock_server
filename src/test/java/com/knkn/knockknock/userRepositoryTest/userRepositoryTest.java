package com.knkn.knockknock.userRepositoryTest;

import com.knkn.knockknock.domain.User;
import com.knkn.knockknock.repository.UserRepository;
import com.knkn.knockknock.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@SpringBootTest
//@Transactional
public class userRepositoryTest {

    @Autowired
    UserService userService;

    @Test
    public void join(){
        User user = new User();
        user.setId("tjrkd222");
        user.setPassword("1234");
        user.setAge("10대");
        user.setJobs("학생");
        user.setNickname("inseoking");
        user.setPhoneVerified(false);
        user.setSex("남");

        userService.signUp(user);

//        Optional<User> result = userService.findById("tjrkd222");
//        System.out.println(result.get().getNickname());
    }
}
