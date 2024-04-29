package com.candenizgumus.springboot_blog.mapper;


import com.candenizgumus.springboot_blog.dto.requests.LikeSaveDto;
import com.candenizgumus.springboot_blog.entities.Like;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LikeMapper
{
    LikeMapper INSTANCE = Mappers.getMapper(LikeMapper.class);




}
