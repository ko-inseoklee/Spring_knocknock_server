package com.knkn.knockknock.repository.matchingRepository;

import com.knkn.knockknock.domain.matching.RequirementAge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface RequirementAgeRepository extends JpaRepository<RequirementAge, Long> {
    ArrayList<RequirementAge> findByMatchingIDEquals(Long matchingID);


}