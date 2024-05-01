package com.candenizgumus.springboot_blog.services;

import com.candenizgumus.springboot_blog.dto.responses.CommentResponseDto;
import com.candenizgumus.springboot_blog.dto.responses.PostResponseDto;
import com.candenizgumus.springboot_blog.entities.Category;
import com.candenizgumus.springboot_blog.entities.Comment;
import com.candenizgumus.springboot_blog.mapper.CommentMapper;
import com.candenizgumus.springboot_blog.mapper.PostMapper;
import com.candenizgumus.springboot_blog.repositories.CategoryRepository;
import com.candenizgumus.springboot_blog.repositories.CommentRepository;
import com.candenizgumus.springboot_blog.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService extends ServiceManager<Comment,Long>
{
    private final CommentRepository commentRepository;


    public CommentService(CommentRepository commentRepository)
    {
        super(commentRepository);
        this.commentRepository = commentRepository;
    }

    public List<CommentResponseDto> findAllDto()
    {
        List<CommentResponseDto>  newCommentList = new ArrayList<>();
        commentRepository.findAll().forEach(comment -> newCommentList.add(CommentMapper.INSTANCE.commentToCommentResponseDto(comment)));

        return newCommentList;
    }
}
