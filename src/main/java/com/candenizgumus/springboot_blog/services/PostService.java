package com.candenizgumus.springboot_blog.services;

import com.candenizgumus.springboot_blog.entities.Category;
import com.candenizgumus.springboot_blog.entities.Post;
import com.candenizgumus.springboot_blog.repositories.CategoryRepository;
import com.candenizgumus.springboot_blog.repositories.PostRepository;
import com.candenizgumus.springboot_blog.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class PostService extends ServiceManager<Post,Long>
{
    private final PostRepository postRepository;


    public PostService(PostRepository postRepository)
    {
        super(postRepository);
        this.postRepository = postRepository;
    }
}
