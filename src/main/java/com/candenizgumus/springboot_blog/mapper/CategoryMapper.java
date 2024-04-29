package com.candenizgumus.springboot_blog.mapper;



import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper
{
    CategoryMapper INSTANCE = Mappers.getMapper( CategoryMapper.class );




}
