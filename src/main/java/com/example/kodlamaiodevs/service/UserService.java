package com.example.kodlamaiodevs.service;

import com.example.kodlamaiodevs.model.dto.CourseDto;
import com.example.kodlamaiodevs.model.dto.UserDto;
import com.example.kodlamaiodevs.model.entity.Course;
import com.example.kodlamaiodevs.model.entity.User;
import com.example.kodlamaiodevs.model.mapper.UserMapper;
import com.example.kodlamaiodevs.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface UserService {


    List<UserDto> getAllUser();

    UserDto getUserById(Long id);

    User createUser(UserDto userDto);

    void deleteByUserId(Long id);

    User updateUser(Long id, UserDto userDto);

    void joinToCourse(long userId, long courseId);

}
