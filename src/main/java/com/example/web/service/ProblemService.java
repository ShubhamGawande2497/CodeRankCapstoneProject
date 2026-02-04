package com.example.web.service;
import com.example.web.dto.ProblemSummaryDto;
import com.example.web.entity.Problems;
import com.example.web.repository.ProblemRepository;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProblemService {

    private final ProblemRepository problemRepository;

    public List<ProblemSummaryDto> listProblems(){
        return problemRepository.findAll().stream().map(p ->
                new ProblemSummaryDto(p.getId(),p.getTitle(),p.getDescription(),
                        p.getDifficulty())).toList();
    }

    public Optional<Problems> getProblem(long id) throws NoSuchElementException {
        return Optional.ofNullable(problemRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Problem not found")));
    }

}
