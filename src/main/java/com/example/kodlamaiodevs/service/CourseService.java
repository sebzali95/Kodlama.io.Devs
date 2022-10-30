package com.example.kodlamaiodevs.service;

import com.example.kodlamaiodevs.enums.ErrorCodeEnum;
import com.example.kodlamaiodevs.exception.CustomNotFoundException;
import com.example.kodlamaiodevs.model.dto.CourseDto;
import com.example.kodlamaiodevs.model.entity.Course;
import com.example.kodlamaiodevs.model.mapper.CourseMapper;
import com.example.kodlamaiodevs.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



public interface CourseService {

    List<CourseDto> getAllCourses();
    Course create(CourseDto courseDto);
    CourseDto getCourseById(Long id);

}
