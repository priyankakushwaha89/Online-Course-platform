package com.example.Online_Course_Platform.Repository;

import com.example.Online_Course_Platform.DTO.InstructorDTO2;
import com.example.Online_Course_Platform.Entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Integer> {

@Query("SELECT new com.example.Online_Course_Platform.DTO.InstructorDTO2(i.id, i.name, c.title) " +
        "FROM Instructor i " +
        "JOIN i.courses c " +
        "WHERE i.id = :id")
    List<InstructorDTO2> findInstructorWithCourses(@Param("id") int id);
}
