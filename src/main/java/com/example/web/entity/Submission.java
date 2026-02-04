package com.example.web.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name="submission")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name="problem_sub")
    private Problems problems;

    @Column(nullable = false)
    private String language; // JAVA | PYTHON | CPP | JS

    @Column(name="source_code", columnDefinition = "TEXT")
    private String sourceCode;

    @Column(name="source_key")
    private String sourceKey;

    @Column (nullable = false)
    private String status; // QUEUED, RUNNING, ACCEPTED, WRONG_ANSWER

    @Column (name = "created_at")
    private OffsetDateTime creadedt = OffsetDateTime.now();

}
