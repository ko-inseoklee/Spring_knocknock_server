package com.knkn.knockknock;

import com.knkn.knockknock.repository.matchingRepository.MatchingRepository;
import com.knkn.knockknock.repository.matchingRepository.RequirementAgeRepository;
import com.knkn.knockknock.repository.UserRepository;
import com.knkn.knockknock.service.MatchingService;
import com.knkn.knockknock.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final UserRepository userRepository;
    private final MatchingRepository matchingRepository;
    private RequirementAgeRepository requirementAgeRepository;

    public SpringConfig(UserRepository userRepository, MatchingRepository matchingRepository,RequirementAgeRepository requirementAgeRepository) {
        this.userRepository = userRepository;
        this.matchingRepository = matchingRepository;
        this.requirementAgeRepository = requirementAgeRepository;
    }

    @Bean
    public UserService userService(){
        return new UserService(userRepository);
    }

    @Bean
    public MatchingService matchingService(){
        return new MatchingService(matchingRepository, requirementAgeRepository);
    }
}
