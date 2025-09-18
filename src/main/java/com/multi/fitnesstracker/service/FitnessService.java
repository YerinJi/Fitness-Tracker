package com.multi.fitnesstracker.service;

import com.multi.fitnesstracker.domain.Fitness;
import com.multi.fitnesstracker.mapper.FitnessMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FitnessService {
    private final FitnessMapper fitnessMapper;

    public List<Fitness> list(){
        return fitnessMapper.getAllFitness();
    }

    @Transactional
    public Fitness getFitnessById(int id){
        return fitnessMapper.getFitnessById(id);
    }

    @Transactional
    public void updateFitness(Fitness fitness){
        fitnessMapper.updateFitness(fitness);
    }

    @Transactional
    public void deleteFitness(int id){
        fitnessMapper.deleteFitness(id);
    }

    @Transactional
    public void insertFitness(Fitness fitness){
        fitnessMapper.insertFitness(fitness);
    }

    // Service
    @Transactional(readOnly = true)
    public int count(String q, String startDate, String endDate) {
        Map<String, Object> params = new HashMap<>();
        params.put("q", (q != null && !q.isBlank()) ? q : null);
        params.put("startDate", (startDate != null && !startDate.isBlank()) ? startDate : null);
        params.put("endDate", (endDate != null && !endDate.isBlank()) ? endDate : null);
        return fitnessMapper.count(params);
    }

    @Transactional(readOnly = true)
    public List<Fitness> find(String q, String startDate, String endDate, int offset, int limit) {
        Map<String, Object> params = new HashMap<>();
        params.put("q", (q != null && !q.isBlank()) ? q : null);
        params.put("startDate", (startDate != null && !startDate.isBlank()) ? startDate : null);
        params.put("endDate", (endDate != null && !endDate.isBlank()) ? endDate : null);
        params.put("offset", offset);
        params.put("limit", limit);
        return fitnessMapper.find(params);
    }



}
