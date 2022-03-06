package com.knkn.knockknock.repository.postRepository;

import com.knkn.knockknock.domain.TopicOfDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicOfDayRepository extends JpaRepository<TopicOfDay, Long> {
    TopicOfDay findByDate(Long date);
}