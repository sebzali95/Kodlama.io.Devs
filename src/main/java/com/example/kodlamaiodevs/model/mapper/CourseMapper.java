package com.example.kodlamaiodevs.model.mapper;

import com.example.kodlamaiodevs.model.dto.CourseDto;
import com.example.kodlamaiodevs.model.entity.Course;

public class CourseMapper {

    public static CourseDto toDto(Course course) {
        CourseDto courseDto = new CourseDto();
        courseDto.setName(course.getName());
        courseDto.setFee(course.getFee());

        return courseDto;
    }

    public static Course toEntity(CourseDto courseDto) {
        Course course = new Course();
        course.setName(courseDto.getName());
        course.setFee(courseDto.getFee());

        return course;
    }
}
