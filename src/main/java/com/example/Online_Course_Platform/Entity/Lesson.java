package com.example.Online_Course_Platform.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Lessonlist")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "less_id")
    int lid;

    @Column(name = "Title")
    @NotNull(message = "Title cannot be Null")
    String title;

    @Column(name = "Content")
    @NotNull(message = "Content must be required")
    String content;
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    @JsonIgnore
    Course course;
    public int getLid() {
        return lid;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
