package com.knkn.knockknock.repository.postRepository;

import com.knkn.knockknock.domain.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
    Comments findByidEquals(Long id);

}