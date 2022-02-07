package com.knkn.knockknock.repository;

import com.knkn.knockknock.domain.matching.Matching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatchingRepository extends JpaRepository<Matching, Long> {

    @Override
    Optional<Matching> findById(Long aLong);
}