package com.knkn.knockknock.matchingServiceTest;

import com.knkn.knockknock.domain.matching.Matching;
import com.knkn.knockknock.service.MatchingService;
import com.knkn.knockknock.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootTest
//@Transactional
public class matchingServiceTest {
    @Autowired
    UserService userService;

    @Autowired
    MatchingService matchingService;

    ArrayList<String> reqAge = new ArrayList<>();

    Matching matching = new Matching("someng2","","대구 갈 사람","여행",reqAge,LocalDate.now());

    @Test
    public void 매칭방생성(){
        reqAge.add("10대");
        reqAge.add("20대");

        boolean result = matchingService.createMatchingRoom(matching);

        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    public void 매칭방입장(){
        매칭방생성();

        boolean result =  matchingService.joinMatchingRoom(1L, "someng");
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    public void 메세지보내기(){

    }

    @Test
    public void 퇴장(){
    }
}
