package com.candenizgumus.springboot_blog.mapper;



import com.candenizgumus.springboot_blog.dto.responses.CommentResponseDto;
import com.candenizgumus.springboot_blog.entities.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper
{
    CommentMapper INSTANCE = Mappers.getMapper( CommentMapper.class );

    CommentResponseDto commentToCommentResponseDto(Comment comment);



}
