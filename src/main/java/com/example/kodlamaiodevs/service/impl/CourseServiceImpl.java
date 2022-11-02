package com.example.kodlamaiodevs.service.impl;
import com.example.kodlamaiodevs.model.dto.CourseDto;
import com.example.kodlamaiodevs.model.entity.Course;
import com.example.kodlamaiodevs.model.mapper.CourseMapper;
import com.example.kodlamaiodevs.repository.CourseRepository;
import com.example.kodlamaiodevs.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<CourseDto> getAllCourses() {
        List<CourseDto> getCourse = courseRepository.findAll()
                .stream()
                .map(course -> CourseMapper.toDto(course))
                .collect(Collectors.toList());
        return getCourse;
    }

    @Override
    public Course create(CourseDto courseDto) {
        Course course = CourseMapper.toEntity(courseDto);
        Course saveCourse = courseRepository.save(course);

        return saveCourse;
    }
    @Override
    public CourseDto getCourseById(Long id) {
        return CourseMapper.toDto(courseRepository.getReferenceById(id));
    }
}
