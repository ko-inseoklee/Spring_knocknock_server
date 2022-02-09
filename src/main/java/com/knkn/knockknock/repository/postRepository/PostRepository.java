package com.knkn.knockknock.repository.postRepository;

import com.knkn.knockknock.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Override
    ArrayList<Post> findAll();
}