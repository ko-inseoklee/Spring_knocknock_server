package com.knkn.knockknock.repository.postRepository;

import com.knkn.knockknock.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}