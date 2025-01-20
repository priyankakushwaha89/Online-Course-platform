package com.example.Online_Course_Platform;

import com.example.Online_Course_Platform.DTO.InstructorDTO;
import com.example.Online_Course_Platform.Entity.Course;
import com.example.Online_Course_Platform.Entity.Instructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class OnlineCoursePlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineCoursePlatformApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {

		return new ModelMapper();
	}
}
