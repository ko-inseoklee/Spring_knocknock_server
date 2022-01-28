package com.knkn.knockknock.service;

import com.knkn.knockknock.domain.Matching;
import com.knkn.knockknock.repository.MatchingRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public class MatchingService {
    private final MatchingRepository matchingRepository;

    public MatchingService(MatchingRepository matchingRepository) {
        this.matchingRepository = matchingRepository;
    }

    public boolean createMatchingRoom(Matching matching){
        try{
            matchingRepository.save(matching);
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
