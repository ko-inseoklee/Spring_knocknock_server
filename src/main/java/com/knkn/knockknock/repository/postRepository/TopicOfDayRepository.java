package com.knkn.knockknock.repository.postRepository;

import com.knkn.knockknock.domain.TopicOfDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicOfDayRepository extends JpaRepository<TopicOfDay, Long> {
    TopicOfDay findByTodayEquals(Long today);

    List<TopicOfDay> findByTodayIsBetween(Long todayStart, Long todayEnd);
}