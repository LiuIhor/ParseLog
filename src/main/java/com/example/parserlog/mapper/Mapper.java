package com.example.parserlog.mapper;

import com.example.parserlog.DTO.UserDTO;
import com.example.parserlog.models.User;
import org.springframework.stereotype.Component;

/**
 * Mapper
 */
@Component
public class Mapper {

    /**
     * Method for mapping from User to UserDto
     * @param user - User for mapping to User DTO
     * @return UserDto
     */
    public static UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setStartDateTime(user.getStartDateTime());
        userDTO.setFinishDateTime(user.getFinishDateTime());
        userDTO.setDuration(user.getDuration());
        userDTO.setDurationInSec(user.getDuration().getSeconds());

        return userDTO;
    }

    /**
     * Method for mapping from UserDto to User
     * @param userDTO - UserDto for mapping to User
     * @return User
     */
    public User toUser(UserDTO userDTO) {
        return new User(userDTO.getId(),
                userDTO.getStartDateTime(),
                userDTO.getFinishDateTime(),
                userDTO.getDuration());
    }
}