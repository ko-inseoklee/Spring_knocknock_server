package com.knkn.knockknock.userRepositoryTest;

import com.knkn.knockknock.domain.User;
import com.knkn.knockknock.repository.UserRepository;
import com.knkn.knockknock.service.UserService;
import org.assertj.core.api.Assertions;
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
        user.setId("someng22");
        user.setPassword("1234");
        user.setAge("20대");
        user.setJobs("개발자");
        user.setNickname("someng");
        user.setSex("여");

        userService.signUp(user);
    }

    @Test
    public void ID중복확인(){
        String id = "tjrkd222";
        boolean result = userService.checkDuplicateID(id);
        Assertions.assertThat(result).isEqualTo(true);
    }
}
