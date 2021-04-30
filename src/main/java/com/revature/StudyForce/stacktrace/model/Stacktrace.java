package com.revature.StudyForce.stacktrace.model;


import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Stacktraces {
    /**
     * @Author : Noel Shaji
     * Primary key
     */
    @Id
    @GeneratedValue
    private int stackstraceId;

    /**
     * TODO: change ints to Objects once user models are created
     * ID of user who created stacktrace
     */
    @NotNull private int creatorId;

    /**
     * the title a user gives to a stacktrace
     */
    @NotBlank
    private String title;

    /**
     * the body text of a stacktrace
     */
    @NotBlank
    private String body;

    /**
     * TODO: change ints to Objects once technology model is added
     * The technology that the stacktrace is using.ex JAVA
     */
    @NotNull private int technologyId;

    /**
     *The timestamp of when the stacktrace was created
     */
    @UpdateTimestamp
    private Timestamp creationTime;

}
