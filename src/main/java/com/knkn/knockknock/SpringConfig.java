//package com.knkn.knockknock;
//
//import com.knkn.knockknock.repository.matchingRepository.MatchingRepository;
//import com.knkn.knockknock.repository.matchingRepository.ChatRepository;
//import com.knkn.knockknock.repository.matchingRepository.RequirementAgeRepository;
//import com.knkn.knockknock.repository.userRepository.UserRepository;
//import com.knkn.knockknock.repository.postRepository.PostRepository;
//import com.knkn.knockknock.service.MatchingService;
//import com.knkn.knockknock.service.PostService;
//import com.knkn.knockknock.service.UserService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SpringConfig {
//    private final UserRepository userRepository;
//    private final MatchingRepository matchingRepository;
//    private final RequirementAgeRepository requirementAgeRepository;
//    private final ChatRepository messageRepository;
//    private final PostRepository postRepository;
//
//    public SpringConfig(UserRepository userRepository, MatchingRepository matchingRepository, RequirementAgeRepository requirementAgeRepository, ChatRepository messageRepository, PostRepository postRepository) {
//        this.userRepository = userRepository;
//        this.matchingRepository = matchingRepository;
//        this.requirementAgeRepository = requirementAgeRepository;
//        this.messageRepository = messageRepository;
//        this.postRepository = postRepository;
//    }
//
//    @Bean
//    public UserService userService(){
//        return new UserService(userRepository);
//    }
//
//    @Bean
//    public MatchingService matchingService(){
//        return new MatchingService(matchingRepository, requirementAgeRepository, messageRepository);
//    }
//
//    @Bean
//    public PostService postService(){
//        return new PostService(postRepository);
//    }
//}
