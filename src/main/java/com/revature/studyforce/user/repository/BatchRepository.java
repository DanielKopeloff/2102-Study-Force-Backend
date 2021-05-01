package com.revature.studyforce.user.repository;

import com.revature.studyforce.user.model.Batch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.sql.Timestamp;

/**
 * Basic repository for {@link Batch}
 * @author Daniel Bernier
 * @author  Daniel Reyes
 */
@RepositoryRestResource(collectionResourceRel = "Batch", path = "batch")
public interface BatchRepository extends JpaRepository<Batch,Integer> {

    /*
     * Find by ID and find All generated by JPA API
     */

    /*
     * Find list of batches with a creation time constraint
     */
    Page<Batch> findByCreationTimeAfter(Timestamp creation, Pageable pageable);

    /*
     * Find batch with certain name
     */
    Batch findByNameIgnoreCase(String name);



}
