package com.example.Online_Course_Platform.Controller;

import com.example.Online_Course_Platform.DTO.InstructorDTO;
import com.example.Online_Course_Platform.DTO.InstructorDTO2;
import com.example.Online_Course_Platform.Entity.Course;
import com.example.Online_Course_Platform.Entity.Instructor;
import com.example.Online_Course_Platform.Entity.Lesson;
import com.example.Online_Course_Platform.Handler.CourseIdNotFoundException;
import com.example.Online_Course_Platform.Handler.DataNotFoundException;
import com.example.Online_Course_Platform.Handler.IdNotFoundException;
import com.example.Online_Course_Platform.Repository.CourseRepository;
import com.example.Online_Course_Platform.Repository.InstructorRepository;

import com.example.Online_Course_Platform.Repository.LessonRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/instructor")
public class InstructorController {

    private final InstructorRepository irepo;
    private final CourseRepository crepo;
    private final LessonRepository lrepo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    public InstructorController(InstructorRepository irepo,ModelMapper modelMapper,CourseRepository crepo,LessonRepository lrepo) {
        this.modelMapper = modelMapper;
        this.irepo = irepo;
        this.crepo=crepo;
        this.lrepo=lrepo;

    }
    @RequestMapping("/test")
    public String test()
    {
        return "Hello Developers! This is Online Course Platform";
    }
    @RequestMapping("/test2")
    public String test2()
    {
        return "Hello EveryOne!";
    }
    @PostMapping("/save")
    public String createInstructorWithCoursesAndLessons(@Valid @RequestBody InstructorDTO instructorDTO) {
        Instructor instructor = new Instructor();
        instructor.setName(instructorDTO.getName());
        instructor.setEmail(instructorDTO.getEmail());
        instructor.setPhoneNumber(instructorDTO.getPhoneNumber());

        List<Course> courses = new ArrayList<>();
        for (InstructorDTO.CourseDTO courseDTO : instructorDTO.getCourses()) {
            Course course = new Course();
            course.setTitle(courseDTO.getTitle());
            course.setDescription(courseDTO.getDescription());
            course.setInstructor(instructor);

            List<Lesson> lessons = new ArrayList<>();
            for (InstructorDTO.LessonDTO lessonDTO : courseDTO.getLessons()) {
                Lesson lesson = new Lesson();
                lesson.setTitle(lessonDTO.getTitle());
                lesson.setContent(lessonDTO.getContent());
                lesson.setCourse(course);
                lessons.add(lesson);
            }
            course.setLessons(lessons);
            courses.add(course);
        }
        instructor.setCourses(courses);

        irepo.save(instructor);
        return "Data saved";
    }
    @RequestMapping("/all")
    public List<Instructor> getAllInstructors()
    {
        List<Instructor> information=irepo.findAll();
        if(information.isEmpty())
        {
            throw new DataNotFoundException();
        }
        return information;
    }
    @GetMapping("/id/{id}")
    public Optional<Instructor> getByInstructorId(@PathVariable int id)
    {
        Optional<Instructor> inst=irepo.findById(id);
        if(inst.isEmpty())
        {
            throw new IdNotFoundException();
        }
        return inst;
    }

    @GetMapping("/course/{cid}")
    public Optional<Course> getByCourseId(@PathVariable int cid)
    {
        Optional<Course> course=crepo.findById(cid);
        if(course.isEmpty())
        {
            throw new CourseIdNotFoundException();
        }
        return course;
    }

    @GetMapping("/name/course/{id}")
    public List<InstructorDTO2> byInstructorId(@PathVariable int id) {
        List<InstructorDTO2> instructorDTO2List = irepo.findInstructorWithCourses(id);

        if (instructorDTO2List.isEmpty()) {
            throw new IdNotFoundException(); // Custom exception if no data is found
        }
        return instructorDTO2List;
    }


    @PutMapping("/update/{id}")
    public String updateById(@PathVariable int id, @Valid @RequestBody InstructorDTO instructorDTO) {
        // Retrieve the instructor by ID
        Optional<Instructor> inst = irepo.findById(id);

        if (inst.isEmpty()) {
            throw new IdNotFoundException();
        }

        // Get the Instructor entity
        Instructor data = inst.get();

        // Update basic fields of the Instructor
        data.setName(instructorDTO.getName());
        data.setEmail(instructorDTO.getEmail());
        data.setPhoneNumber(instructorDTO.getPhoneNumber());

        // Update the courses while preserving existing relationships
        List<Course> existingCourses = data.getCourses();
        existingCourses.clear(); // Clear existing courses

        for (InstructorDTO.CourseDTO courseDTO : instructorDTO.getCourses()) {
            Course course = new Course();
            course.setTitle(courseDTO.getTitle());
            course.setDescription(courseDTO.getDescription());
            course.setInstructor(data); // Set the current instructor

            // Handle lessons for the course
            List<Lesson> lessons = new ArrayList<>();
            for (InstructorDTO.LessonDTO lessonDTO : courseDTO.getLessons()) {
                Lesson lesson = new Lesson();
                lesson.setTitle(lessonDTO.getTitle());
                lesson.setContent(lessonDTO.getContent());
                lesson.setCourse(course); // Associate lesson with the course
                lessons.add(lesson);
            }

            course.setLessons(lessons); // Set the lessons to the course
            existingCourses.add(course); // Add the course to the instructor's courses
        }

        // Save the updated Instructor
        irepo.save(data);

        return "Data updated";
    }


    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id)
    {
        Optional<Instructor> instructor=irepo.findById(id);
        if(instructor.isEmpty())
        {
            throw new IdNotFoundException();
        }
        irepo.deleteById(id);
        return "Data deleted";
    }

}

