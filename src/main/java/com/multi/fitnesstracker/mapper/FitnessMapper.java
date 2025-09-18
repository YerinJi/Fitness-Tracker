package com.multi.fitnesstracker.mapper;

import com.multi.fitnesstracker.domain.Fitness;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface FitnessMapper {
    List<Fitness> getAllFitness();
    void insertFitness(Fitness fitness);
    void updateFitness(Fitness fitness);
    void deleteFitness(@Param("id") int id);
    Fitness getFitnessById(@Param("id") int id);
    int count(Map<String, Object> params);
    List<Fitness> find(Map<String, Object> params);

}
