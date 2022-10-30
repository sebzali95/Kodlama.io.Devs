package com.example.kodlamaiodevs.service.impl;

import com.example.kodlamaiodevs.enums.ErrorCodeEnum;
import com.example.kodlamaiodevs.exception.CustomNotFoundException;
import com.example.kodlamaiodevs.model.dto.UserDto;
import com.example.kodlamaiodevs.model.entity.Course;
import com.example.kodlamaiodevs.model.entity.User;
import com.example.kodlamaiodevs.model.mapper.UserMapper;
import com.example.kodlamaiodevs.repository.CourseRepository;
import com.example.kodlamaiodevs.repository.UserRepository;
import com.example.kodlamaiodevs.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    @Override
    public List<UserDto> getAllUser() {
        List<UserDto> allUser = userRepository.findAll()
                .stream()
                .map(user -> UserMapper.toDto(user))
                .collect(Collectors.toList());

        return allUser;
    }

    @Override
    public UserDto getUserById(Long id) {
        return UserMapper.toDto(userRepository.getReferenceById(id));
    }

    @Override
    public User createUser(UserDto userDto) {
        User user = UserMapper.toEntity(userDto);
        User save = userRepository.save(user);
        return save;
    }

    @Override
    public void deleteByUserId(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(Long id, UserDto userDto) {
        Optional<User> byId = userRepository.findById(id);
        if (!byId.isPresent()) {
            return null;
        }
        User updatedUser = byId.get();
        if (!StringUtils.isEmpty(userDto.getAge())) {
            updatedUser.setAge(userDto.getAge());
        }
        if (!StringUtils.isEmpty(userDto.getFirstName())) {
            updatedUser.setFirstName(userDto.getFirstName());
        }
        if (!StringUtils.isEmpty(userDto.getLastName())) {
            updatedUser.setLastName(userDto.getLastName());
        }
        return userRepository.save(updatedUser);
    }

    @Override
    public void joinToCourse(long userId, long courseId) {
        User user = userRepository.findById(userId).orElseThrow(()->
                new CustomNotFoundException(ErrorCodeEnum.USER_NOT_FOUND));
        Course course = courseRepository.findById(courseId).orElseThrow(()->
                new CustomNotFoundException(ErrorCodeEnum.USER_NOT_FOUND));

        List<Course> courses = user.getCourses();
        courses.add(course);
        user.setCourses(courses);
        userRepository.save(user);
    }

}
