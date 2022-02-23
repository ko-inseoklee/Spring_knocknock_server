package com.knkn.knockknock.repository.postRepository;

import com.knkn.knockknock.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Override
    ArrayList<Post> findAll();

    ArrayList<Post> findByTitleContains(String title);

    Post findByIdEquals(Long id);

    ArrayList<Post> findByAgeContains(String age);

    //TODO: 직접 짠 쿼리로 작동이 되면 cnt 정해서 그 숫자만큼만 가져오기. => 현재는 다 불러오고 후처리 작업으로 진행.
    ArrayList<Post> findByLikeCntIsGreaterThan(int likeCnt);




}