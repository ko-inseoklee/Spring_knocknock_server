package com.knkn.knockknock.service;

import com.knkn.knockknock.domain.matching.Matching;
import com.knkn.knockknock.domain.matching.RequirementAge;
import com.knkn.knockknock.repository.MatchingRepository;
import com.knkn.knockknock.repository.RequirementAgeRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Transactional
public class MatchingService {
    private final MatchingRepository matchingRepository;
    private final RequirementAgeRepository requirementAgeRepository;

    public MatchingService(MatchingRepository matchingRepository, RequirementAgeRepository requirementAgeRepository) {
        this.matchingRepository = matchingRepository;
        this.requirementAgeRepository = requirementAgeRepository;
    }

    public boolean checkValidation(Matching matching){
        // 로그인 상태가 아니거나, 연령, 카테고리, 제목 등이 입력되지 않은 경우.
        return matching.getRequirementsAge().size() != 0
                && matching.getTitle() != ""
                && matching.getCategory() != ""
                && matching.getOwnerID() != "";
    }

    public boolean createMatchingRoom(Matching matching){
        try{
            if(checkValidation(matching)) {
                matchingRepository.save(matching);

                ArrayList<RequirementAge> reqs = new ArrayList<>();

                for (String req:
                        matching.getRequirementsAge()) {
                    reqs.add(new RequirementAge(matching.getId(), req));
                }

                requirementAgeRepository.saveAll(reqs);
            }
            else return false;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    public boolean joinMatchingRoom(Long roomID, String joiner) {
        Optional<Matching> optional = matchingRepository.findById(roomID);
        if (optional.isPresent()) {
            Matching matching = optional.get();
            matching.setJoinerID(joiner);
            matchingRepository.saveAndFlush(matching);
            return true;
        }else{
            return false;
        }

    }
}
