package com.candenizgumus.springboot_blog.mapper;



import com.candenizgumus.springboot_blog.dto.requests.CategorySaveDto;
import com.candenizgumus.springboot_blog.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper
{
    CategoryMapper INSTANCE = Mappers.getMapper( CategoryMapper.class );

    Category categorySaveDtoToCategory(CategorySaveDto dto);



}
