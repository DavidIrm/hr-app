package com.sda.project.mapper;

import com.sda.project.DTO.UserDto;
import com.sda.project.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserMapper {

    public User map(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());

        user.setPassword(userDto.getPassword());

return user;
    }


    public UserDto map(User user){

        UserDto userDto = new UserDto();

        userDto.setEmail(user.getEmail());

        userDto.setPassword(user.getPassword());

        return userDto;
    }


    public List<UserDto> map(List<User> users){
        List<UserDto> result = new ArrayList<>();

        for(User user: users){
//             UserDto userDto = map(user);
//            result.add(userDto);
            result.add(map(user));
        }
        return result;
    }

}