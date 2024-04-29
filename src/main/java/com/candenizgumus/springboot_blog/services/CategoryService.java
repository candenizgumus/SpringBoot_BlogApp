package com.candenizgumus.springboot_blog.services;

import com.candenizgumus.springboot_blog.dto.requests.CategorySaveDto;
import com.candenizgumus.springboot_blog.entities.Category;
import com.candenizgumus.springboot_blog.exceptions.BlogAppException;
import com.candenizgumus.springboot_blog.exceptions.ErrorType;
import com.candenizgumus.springboot_blog.mapper.CategoryMapper;
import com.candenizgumus.springboot_blog.repositories.CategoryRepository;
import com.candenizgumus.springboot_blog.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService extends ServiceManager<Category,Long>
{
    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository)
    {
        super(categoryRepository);
        this.categoryRepository = categoryRepository;
    }

    public Category saveDto(CategorySaveDto dto)
    {
        Category category = CategoryMapper.INSTANCE.categorySaveDtoToCategory(dto);
        return save(category);
    }

    public Category findByNameIgnoreCase(String name){

        return categoryRepository.findByNameIgnoreCase(name).orElseThrow(() -> new BlogAppException(ErrorType.CATEGORY_NOT_FOUND));
    }
}
