package com.multi.fitnesstracker.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
public class Fitness {
    private int id;
    private String exerciseName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate workoutDate;
    private int durationMin;
    private int calories;
    private String memo;
    private Date createdAt;
}
