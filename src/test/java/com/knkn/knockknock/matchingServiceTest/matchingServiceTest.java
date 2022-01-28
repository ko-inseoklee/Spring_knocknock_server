package com.knkn.knockknock.matchingServiceTest;

import com.knkn.knockknock.domain.Matching;
import com.knkn.knockknock.service.MatchingService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@SpringBootTest
//@Transactional
public class matchingServiceTest {
    @Autowired
    MatchingService matchingService;

    @Test
    public void 매칭방생성(){
        Matching matching = new Matching();
        matching.setOwnerID("tjrkd222");
        matching.setJoinerID("");
        matching.setCategory("학업");
        matching.setCreationTime(new Date().getTime());

        boolean result = matchingService.createMatchingRoom(matching);

        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    public void 매칭방입장(){
        Long mID = 1L;
        Matching matching = new Matching();
        matching.setOwnerID("tjrkd222");
        matching.setJoinerID("");
        matching.setCategory("학업");
        matching.setCreationTime(new Date().getTime());

        boolean result = matchingService.createMatchingRoom(matching);

        if(result) result = matchingService.joinMatchingRoom(mID, "someng");
        Assertions.assertThat(result).isEqualTo(true);
    }
}
