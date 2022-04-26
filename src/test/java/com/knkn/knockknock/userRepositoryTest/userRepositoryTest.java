//package com.knkn.knockknock.userRepositoryTest;
//
//import com.knkn.knockknock.domain.user.Confirm;
//import com.knkn.knockknock.domain.user.User;
//import com.knkn.knockknock.service.ConfirmService;
//import com.knkn.knockknock.service.UserService;
//import net.nurigo.java_sdk.exceptions.CoolsmsException;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
////@Transactional
//public class userRepositoryTest {
//
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    ConfirmService confirmService;
//
//    @Test
//    public void join(){
//        User user = new User();
//        user.setId("someng22");
//        user.setPassword("1234");
//        user.setAge("20대");
//        user.setJobs("개발자");
//        user.setNickname("someng");
//        user.setSex("여");
//
//        userService.signUp(user);
//    }
//
//    @Test
//    public void ID중복확인(){
//        String id = "tjrkd222";
//        boolean result = userService.checkDuplicateID(id);
//        Assertions.assertThat(result).isEqualTo(true);
//    }
//
//    @Test
//    public void 인증번호전송() throws CoolsmsException {
//        userService.sendAuthMessage("01027765098");
//    }
//
//    @Test
//    public void 인증번호확인(){
////        Confirm confirm = confirmService.callConfirm("01027765098");
////        Assertions.assertThat(confirm.getValidationNumber()).isEqualTo("4478");
//
//        Assertions.assertThat(userService.validatePhoneAuth("01027765098","4478")).isEqualTo(true);
//    }
//}
