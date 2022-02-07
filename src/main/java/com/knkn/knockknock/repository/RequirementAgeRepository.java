package com.knkn.knockknock.repository;

import com.knkn.knockknock.domain.matching.RequirementAge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequirementAgeRepository extends JpaRepository<RequirementAge, Long> {
    List<RequirementAge> findByMatchingID(Long matchingID);

}