package com.candenizgumus.springboot_blog.services;

import com.candenizgumus.springboot_blog.entities.Post;
import com.candenizgumus.springboot_blog.entities.User;
import com.candenizgumus.springboot_blog.repositories.PostRepository;
import com.candenizgumus.springboot_blog.repositories.UserRepository;
import com.candenizgumus.springboot_blog.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceManager<User,Long>
{
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository)
    {
        super(userRepository);
        this.userRepository = userRepository;
    }
}
