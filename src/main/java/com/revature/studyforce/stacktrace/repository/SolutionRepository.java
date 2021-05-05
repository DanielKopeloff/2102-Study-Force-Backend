package com.revature.studyforce.stacktrace.repository;


import com.revature.studyforce.stacktrace.model.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Basic repository for {@link Solution}
 * @author Joey Elmblad
 * @author Joshua Swanson
 */
@Repository
public interface SolutionRepository extends JpaRepository<Solution,Integer> {

    @Modifying
    @Query("from Solution where stacktrace_id = :stackTraceId")
    List<Solution> findByStackTraceId(@Param("stackTraceId") int stacktraceId);

    @Transactional
    @Modifying
    @Query("delete from Solution where solution_id = :solutionId")
    void deleteBySolutionId(@Param("solutionId") int solutionId);

    Solution findBySolutionId(@Param("solutionId") int solutionId);

    @Transactional
    @Modifying
    @Query("update solution\n" +
            "set total_votes = (select SUM(value) from solution_vote where solution_id = :solutionId)\n" +
            "where solution_id = :solutionId;")
    Solution updateSolutionTotalVotesBySolutionId(@Param("solutionId") int solutionId);
}
