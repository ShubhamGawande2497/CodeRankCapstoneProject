package com.example.web.controller;


import com.example.web.dto.SubmissionRequestDto;
import com.example.web.dto.SubmissionResponseDto;
import com.example.web.service.SubmissionService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/submission")
public class SubmissionController {

    private final SubmissionService submissionService;

    @PostMapping("{problemId}/submit")
    public ResponseEntity<SubmissionResponseDto> submit(@PathVariable long problemId,
                                                        @RequestBody SubmissionRequestDto req){
        return ResponseEntity.ok(submissionService.createSubmission(problemId,req));
    }

}
