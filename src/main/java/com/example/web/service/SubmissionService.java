package com.example.web.service;


import com.example.web.dto.SubmissionRequestDto;
import com.example.web.dto.SubmissionResponseDto;
import com.example.web.entity.Problems;
import com.example.web.entity.Submission;
import com.example.web.repository.ProblemRepository;
import com.example.web.repository.SubmissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class SubmissionService {

    private final ProblemRepository problemRepository;
    private final SubmissionRepository submissionRepository;


    public SubmissionResponseDto createSubmission(long problemId, SubmissionRequestDto req){

        Problems p = problemRepository.findById(problemId)
                .orElseThrow(() -> new NoSuchElementException("Problem not found"));

        Submission sub = Submission.builder()
                .problems(p)
                .language(req.language())
                .sourceCode(req.code())
                .status("CREATED")
                .build();
        submissionRepository.save(sub);

        return new SubmissionResponseDto(sub.getId(), sub.getStatus());
    }
}
