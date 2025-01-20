package com.example.Online_Course_Platform.DTO;

import com.example.Online_Course_Platform.Entity.Course;
import com.example.Online_Course_Platform.Entity.Instructor;
import com.example.Online_Course_Platform.Entity.Lesson;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

import java.util.List;

public class InstructorDTO {
    private String name;
    private String email;
    private String phoneNumber;
    private List<CourseDTO> courses;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCourses(List<CourseDTO> courses) {
        this.courses = courses;
    }

    public static class CourseDTO {
        private String title;
        private String description;
        private List<LessonDTO> lessons;

        // Getters and Setters

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public List<LessonDTO> getLessons() {
            return lessons;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setLessons(List<LessonDTO> lessons) {
            this.lessons = lessons;
        }
    }

    public static class LessonDTO {
        private String title;
        private String content;

        // Getters and Setters

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}

