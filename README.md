# 🏋️‍♀️ MyBatisProject

간단한 **운동 기록 관리 웹 애플리케이션**입니다.
Spring Boot + Thymeleaf + MyBatis + MySQL 기반으로 제작되었습니다.


## 🛠 주요 기능

1. **운동 기록 관**  
   - 등록 (운동명, 날짜, 운동 시간(분), 칼로리, 메모)
   - 수정, 삭제, 상세보기
2. **검색 & 페이**  
   - 운동명 부분 검색 (LIKE)
   - 날짜 범위 검색 (startDate ~ endDate)
   - 페이징 처리 (페이지 블록 단위 네비게이션)
3. **UI (Bootstrap 기반)**  
   - 반응형 레이아웃
   - 테이블, 폼, 버튼 Bootstrap 스타일 적용
---

## 🗂 목차
1. [⚙ 환경 설정](#-환경-설정)
2. [🛢 DB 생성](#-db-생성)
3. [🌐 엔드포인트](#-엔드포인트)
4. [🖥 화면 구성](#-화면-구성)
5. [🎥시연 영상](#-시연-영상)

---

## ⚙ 환경 설정
- **Spring Boot**: 3.x
- **MySQL**: 8.x
- **빌드 도구**: Gradle
- **IDE**: IntelliJ
- **서버 포트**: 8080  

---

## 🛢 DB 생성 

### DB 생성
<details><summary>SQL 보기</summary>

```sql
CREATE DATABASE fitnesstracker;
USE fitnesstracker;

CREATE TABLE workout (
  id INT AUTO_INCREMENT PRIMARY KEY,
  exercise_name VARCHAR(255) NOT NULL,
  workout_date DATE NOT NULL,
  duration_min INT,
  calories INT,
  memo TEXT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 인덱스 추천
CREATE INDEX idx_exercise_name ON workout(exercise_name);
CREATE INDEX idx_workout_date ON workout(workout_date);

```
</details>


## 🌐 엔드포인트
| Method | Path              | 설명                 | 파라미터                                                     |
| ------ | ----------------- | ------------------ | -------------------------------------------------------- |
| GET    | `/fitness`        | 운동 기록 목록 (페이징, 검색) | `page`, `size`, `q`, `startDate`, `endDate`              |
| GET    | `/fitness/new`    | 운동 기록 등록 폼         |                                                          |
| POST   | `/fitness`        | 운동 기록 등록 처리        | `exerciseName, workoutDate, durationMin, calories, memo` |
| GET    | `/fitness/view`   | 운동 기록 상세보기         | `id`                                                     |
| GET    | `/fitness/edit`   | 운동 기록 수정 폼         | `id`                                                     |
| POST   | `/fitness/update` | 운동 기록 수정 처리        | 위와 동일                                                    |
| POST   | `/fitness/delete` | 운동 기록 삭제 처리        | `id`                                                     |


## 🖥 화면 구성
- fitness.html : 운동 기록 목록 + 검색 + 페이징
- fitness/new.html : 등록 폼
- fitness/edit.html : 수정 폼
- fitness/view.html : 운동 기록 상세

## 🎥 시연 영상

[[시연 영상 주소]](시연영상.mp4)

