package com.candenizgumus.springboot_blog.services;

import com.candenizgumus.springboot_blog.dto.responses.UserResponseDto;
import com.candenizgumus.springboot_blog.entities.Post;
import com.candenizgumus.springboot_blog.entities.User;
import com.candenizgumus.springboot_blog.mapper.UserMapper;
import com.candenizgumus.springboot_blog.repositories.PostRepository;
import com.candenizgumus.springboot_blog.repositories.UserRepository;
import com.candenizgumus.springboot_blog.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService extends ServiceManager<User,Long>
{
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository)
    {
        super(userRepository);
        this.userRepository = userRepository;
    }

    public List<UserResponseDto> findAllDto()
    {
        List<UserResponseDto>  newUserList = new ArrayList<>();
        userRepository.findAll().forEach(user -> newUserList.add(UserMapper.INSTANCE.userToUserResponseDto(user)));

        return newUserList;

    }
}
