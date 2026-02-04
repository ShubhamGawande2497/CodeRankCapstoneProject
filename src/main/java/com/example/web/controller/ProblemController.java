package com.example.web.controller;


import com.example.web.dto.ProblemSummaryDto;
import com.example.web.entity.Problems;
import com.example.web.service.ProblemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/problem")
public class ProblemController {

    private final ProblemService problemService;

    @GetMapping("/problemsList")
    public List<ProblemSummaryDto> problemLists()
    {
        System.out.println("Hello I am in Controller");
        return problemService.listProblems();
    }

    @GetMapping("/problemsList/{id}")
    public Optional<Problems> get(@PathVariable long id)
    {
        return problemService.getProblem(id);
    }
}
