package com.knkn.knockknock.userRepositoryTest;

import com.knkn.knockknock.service.ConfirmService;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ConfirmServiceTest {
    @Autowired
    ConfirmService confirmService;

    @Test
    public void 인증번호전송() throws CoolsmsException {
        confirmService.sendMessage("01038843932");
    }
}
