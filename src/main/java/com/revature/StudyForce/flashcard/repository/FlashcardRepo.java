package com.revature.StudyForce.flashcard.repository;

import com.revature.StudyForce.flashcard.model.Flashcard;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring repository for Flashcards
 *
 * @author Luke
 */
@Repository
public interface FlashcardRepo extends JpaRepository<Flashcard, Integer> {

    // Find questions by difficulty
    List<Flashcard> findALlByQuestionDifficultyTotal(int questionDifficultyTotal, Pageable pageable);
}
