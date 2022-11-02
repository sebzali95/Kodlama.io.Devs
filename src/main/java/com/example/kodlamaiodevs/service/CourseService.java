package com.example.kodlamaiodevs.service;
import com.example.kodlamaiodevs.model.dto.CourseDto;
import com.example.kodlamaiodevs.model.entity.Course;
import java.util.List;



public interface CourseService {

    List<CourseDto> getAllCourses();
    Course create(CourseDto courseDto);
    CourseDto getCourseById(Long id);

}
