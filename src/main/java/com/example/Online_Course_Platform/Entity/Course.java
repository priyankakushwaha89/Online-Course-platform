package com.example.Online_Course_Platform.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="CourseList")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    int cid;

    @Column(name= "Title")
    @NotNull(message = "Title can not be Null")
    String title;

    @Column(name = "Description")
    @NotEmpty(message = "Description must be required")
    String description;
    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    @JsonIgnore
    private Instructor instructor;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lesson> lessons=new ArrayList<>();

    public int getCid() {
        return cid;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
