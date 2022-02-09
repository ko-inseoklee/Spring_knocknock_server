package com.knkn.knockknock.service;

import com.knkn.knockknock.domain.Post;
import com.knkn.knockknock.repository.postRepository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    ArrayList<Post> loadPosts(){
        return postRepository.findAll();
    }


}
