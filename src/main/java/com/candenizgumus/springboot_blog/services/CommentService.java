package com.candenizgumus.springboot_blog.services;

import com.candenizgumus.springboot_blog.entities.Category;
import com.candenizgumus.springboot_blog.entities.Comment;
import com.candenizgumus.springboot_blog.repositories.CategoryRepository;
import com.candenizgumus.springboot_blog.repositories.CommentRepository;
import com.candenizgumus.springboot_blog.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends ServiceManager<Comment,Long>
{
    private final CommentRepository commentRepository;


    public CommentService(CommentRepository commentRepository)
    {
        super(commentRepository);
        this.commentRepository = commentRepository;
    }
}
