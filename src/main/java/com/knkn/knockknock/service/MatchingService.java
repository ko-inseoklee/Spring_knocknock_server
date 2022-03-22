package com.knkn.knockknock.service;

import com.knkn.knockknock.domain.user.User;
import com.knkn.knockknock.domain.matching.Matching;
import com.knkn.knockknock.domain.matching.RequirementAge;
import com.knkn.knockknock.domain.matching.*;
import com.knkn.knockknock.repository.matchingRepository.MatchingRepository;
import com.knkn.knockknock.repository.matchingRepository.ChatRepository;
import com.knkn.knockknock.repository.matchingRepository.RequirementAgeRepository;
import com.knkn.knockknock.repository.userRepository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Transactional
@Service
public class MatchingService {
    private final MatchingRepository matchingRepository;
    private final RequirementAgeRepository requirementAgeRepository;
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    public MatchingService(MatchingRepository matchingRepository, RequirementAgeRepository requirementAgeRepository, ChatRepository messageRepository, UserRepository userRepository) {
        this.matchingRepository = matchingRepository;
        this.requirementAgeRepository = requirementAgeRepository;
        this.chatRepository = messageRepository;
        this.userRepository = userRepository;
    }

    public Matching getMatching(Long roomID){
        return matchingRepository.findById(roomID).get();
    }

    public boolean checkValidation(Matching matching) {
        // 로그인 상태가 아니거나, 연령, 카테고리, 제목 등이 입력되지 않은 경우.
        return matching.getRequirementsAge().size() != 0
                && matching.getTitle() != ""
                && matching.getCategory() != ""
                && matching.getOwnerID() != "";
    }

    //TODO: status Code 내보내기
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



    public boolean joinMatchingRoom(Long roomID, String uid) {
        Optional<Matching> optional = matchingRepository.findById(roomID);
        Optional<User> userOptional = userRepository.findByIdEquals(uid);
        if (optional.isPresent() && userOptional.isPresent()) {
            Matching matching = optional.get();
            User user = userOptional.get();

            ArrayList<RequirementAge> requirementAges = requirementAgeRepository.findByMatchingIDEquals(roomID);

            boolean contain = false;

            for (RequirementAge requirementAge : requirementAges) {
                if(requirementAge.getAge() == user.getAge()){
                    contain = true;
                    break;
                }
            }

            if(contain){
                matching.setJoinerID(user.getId());
                matchingRepository.saveAndFlush(matching);
                return true;
            }else return false;

        }else return false;
    }

    public boolean sendMessage(Long roomID, String sender, String message){
        try{
            Chat m = new Chat(roomID,sender,message);

            chatRepository.save(m);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean exit(Long roomID, String userID){
        Matching result = matchingRepository.getById(roomID);

        try{
            if(result.getOwnerID() == userID){
                ArrayList<RequirementAge> requirementAges = requirementAgeRepository.findByMatchingIDEquals(roomID);
                for(RequirementAge requirementAge: requirementAges){
                    requirementAgeRepository.delete(requirementAge);
                }

                ArrayList<Chat> chats = chatRepository.findByRoomIDEquals(roomID);
                for(Chat chat: chats){
                    chatRepository.delete(chat);
                }

                matchingRepository.delete(result);
            }
            else{
                result.setJoinerID("");
                matchingRepository.saveAndFlush(result);
            }

            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
