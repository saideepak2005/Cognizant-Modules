package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Integer> {

    @Query("""
        SELECT a 
        FROM Attempt a 
        JOIN FETCH a.user 
        JOIN FETCH a.questionList aq 
        JOIN FETCH aq.question q 
        JOIN FETCH q.optionList 
        JOIN FETCH aq.attemptOptionList ao 
        JOIN FETCH ao.option 
        WHERE a.user.userId = :userId 
        AND a.attemptId = :attemptId
    """)
    Attempt getAttempt(@Param("userId") int userId, @Param("attemptId") int attemptId);

}
