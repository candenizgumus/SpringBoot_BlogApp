package com.candenizgumus.springboot_blog.services;

import com.candenizgumus.springboot_blog.entities.Category;
import com.candenizgumus.springboot_blog.entities.Post;
import com.candenizgumus.springboot_blog.repositories.CategoryRepository;
import com.candenizgumus.springboot_blog.repositories.PostRepository;
import com.candenizgumus.springboot_blog.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService extends ServiceManager<Post,Long>
{
    private final PostRepository postRepository;


    public PostService(PostRepository postRepository)
    {
        super(postRepository);
        this.postRepository = postRepository;
    }

    public List<Post> findAllByOrderByPublishdateDesc(){
        return postRepository.findAllByOrderByPublishdateDesc();
    }

    public List<Post> findAllByCategory_Id(Long categoryId){
        return postRepository.findAllByCategory_Id(categoryId);
    }

    public List<Post> findAllByUser_Id(Long userId){
        return postRepository.findAllByUser_Id(userId);
    }
}
