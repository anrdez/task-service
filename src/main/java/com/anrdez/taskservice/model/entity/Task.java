package com.anrdez.taskservice.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * @author anrdez
 * @project task-service
 */

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 500)
    private String description;


    /**
     * When you use TemporalType.TIMESTAMP in the @Temporal annotation,
     * it means that both the date and time information will be stored
     * in the database.
     */
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;


}
