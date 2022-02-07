package com.knkn.knockknock.matchingServiceTest;

import com.knkn.knockknock.domain.matching.Matching;
import com.knkn.knockknock.service.MatchingService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootTest
//@Transactional
public class matchingServiceTest {
    @Autowired
    MatchingService matchingService;

    @Test
    public void 매칭방생성(){
        ArrayList<String> reqAge = new ArrayList<>();
        reqAge.add("10대");
        reqAge.add("20대");
        Matching matching = new Matching("someng2","","대구 갈 사람","여행",reqAge,LocalDate.now());
//
        boolean result = matchingService.createMatchingRoom(matching);

        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    public void 매칭방입장(){
//        Long mID = 1L;
//        Matching matching = new Matching(id, ownerID, joinerID, category, requirements_sex, requirementsAge, creationTime);
//        matching.setOwnerID("tjrkd222");
//        matching.setJoinerID("");
//        matching.setCategory("학업");
//        matching.setCreationTime(new Date().getTime());
//
//        boolean result = matchingService.createMatchingRoom(matching);
//
//        if(result) result = matchingService.joinMatchingRoom(mID, "someng");
//        Assertions.assertThat(result).isEqualTo(true);
    }
}
