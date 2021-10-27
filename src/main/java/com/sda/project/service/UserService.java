package com.sda.project.service;

import com.sda.project.DTO.UserDto;
import com.sda.project.mapper.UserMapper;
import com.sda.project.model.Employer;
import com.sda.project.model.User;
import com.sda.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;


    private void addUser(UserDto userDto) {

        User user = userMapper.map(userDto);

        userRepository.save(user);


    }
    // reprezinta functionalizatea cu care sa obtina o lista de useriDTO
    public List<UserDto> getAllUsers(){
        List<User> allUsers = userRepository.findAll();
        List<UserDto> result = userMapper.map(allUsers);

        return result;
    }

}