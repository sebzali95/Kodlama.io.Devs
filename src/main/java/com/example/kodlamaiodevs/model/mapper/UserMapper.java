package com.example.kodlamaiodevs.model.mapper;


import com.example.kodlamaiodevs.model.dto.UserDto;
import com.example.kodlamaiodevs.model.entity.User;

public class UserMapper {

    public static UserDto toDto(User user) {

        UserDto userDto = new UserDto();
        userDto.setId(user.getUserId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setAge(user.getAge());

        return userDto;
    }

    public static User toEntity(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAge(userDto.getAge());

        return user;
    }

}
