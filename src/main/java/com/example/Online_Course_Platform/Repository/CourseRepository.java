package com.example.Online_Course_Platform.Repository;

import com.example.Online_Course_Platform.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
}
