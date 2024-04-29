package com.candenizgumus.springboot_blog.services;

import com.candenizgumus.springboot_blog.entities.Category;
import com.candenizgumus.springboot_blog.repositories.CategoryRepository;
import com.candenizgumus.springboot_blog.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends ServiceManager<Category,Long>
{
    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository)
    {
        super(categoryRepository);
        this.categoryRepository = categoryRepository;
    }
}
