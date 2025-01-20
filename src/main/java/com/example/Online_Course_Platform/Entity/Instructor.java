package com.example.Online_Course_Platform.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Instructorlist")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inst_id")
    int id;

    @Column(name="Name")
    @NotNull(message = "Name can not be Null")
    String name;
    @Column(name = "Email")
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    String email;
    @Column(name="Phone No:",updatable = true,nullable = false,insertable = true,unique = true)
    @NotBlank(message = "Please enter phone number ")
    @Pattern(regexp="^[6-9]{1}[0-9]{9}$",message = "Please Enter An Valid Phone No")
    String phoneNumber;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Course> courses=new ArrayList<>();
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
