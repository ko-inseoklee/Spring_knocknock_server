package com.knkn.knockknock.matchingServiceTest;

import com.knkn.knockknock.domain.User;
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
    User validUser = new User("tjrkd222","1234", "10대", "inseoking", "남","학생");
    User invalidUser = new User("tjrkd222","1234", "30대", "inseoking", "남","학생");
    User ownerUser = new User("someng2","1234", "10대", "somengmeng", "여","학생");

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

        boolean result =  matchingService.joinMatchingRoom(1L, validUser);
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    public void 매칭방입장불가(){
        매칭방생성();

        boolean result =  matchingService.joinMatchingRoom(1L, invalidUser);
        Assertions.assertThat(result).isEqualTo(false);
    }

    @Test
    public void 메세지보내기(){
        매칭방입장();

        boolean result1 = matchingService.sendMessage(1L,validUser.getId(),"안녕하세요.");
        boolean result2 = matchingService.sendMessage(1L,validUser.getId(),"이인석입니다.");

        Assertions.assertThat(result1 && result2).isEqualTo(true);

    }

    @Test
    public void 퇴장(){
        매칭방생성();
        매칭방입장();
        메세지보내기();

        boolean result = matchingService.exit(1L, validUser.getId());

        Assertions.assertThat(result).isEqualTo(true);

    }

    @Test
    public void 방삭제(){
        매칭방생성();
        매칭방입장();
        메세지보내기();

        boolean result = matchingService.exit(1L, ownerUser.getId());

        Assertions.assertThat(result).isEqualTo(true);
    }
}
