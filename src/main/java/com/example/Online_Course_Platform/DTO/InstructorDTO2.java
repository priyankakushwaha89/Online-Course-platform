package com.example.Online_Course_Platform.DTO;

public class InstructorDTO2 {

int id;
String name;
String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public InstructorDTO2(int id, String name, String title) {
        this.id = id;
        this.name = name;
        this.title = title;
    }
}
