package com.knkn.knockknock.repository.postRepository;

import com.knkn.knockknock.domain.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {
    Optional<Comments> findByCommentIDEquals(Long CommentID);

}