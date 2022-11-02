package com.example.kodlamaiodevs.service;
import com.example.kodlamaiodevs.model.dto.UserDto;
import com.example.kodlamaiodevs.model.entity.User;
import java.util.List;

public interface UserService {

    List<UserDto> getAllUser();

    UserDto getUserById(Long id);

    User createUser(UserDto userDto);

    void deleteByUserId(Long id);

    User updateUser(Long id, UserDto userDto);

    void joinToCourse(long userId, long courseId);

}
