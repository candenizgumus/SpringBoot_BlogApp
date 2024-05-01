package com.candenizgumus.springboot_blog.mapper;



import com.candenizgumus.springboot_blog.dto.responses.PostResponseDto;
import com.candenizgumus.springboot_blog.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper
{
    PostMapper INSTANCE = Mappers.getMapper( PostMapper.class );

    PostResponseDto postToPostResponseDto( Post post);



}
