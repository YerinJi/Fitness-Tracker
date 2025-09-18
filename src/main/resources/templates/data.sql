CREATE DATABASE fitnessdb DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

use fitnessdb;

CREATE TABLE workout (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         exercise_name VARCHAR(100) NOT NULL,
                         workout_date DATE NOT NULL,
                         duration_min INT NOT NULL,
                         calories INT,
                         memo VARCHAR(255),
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);