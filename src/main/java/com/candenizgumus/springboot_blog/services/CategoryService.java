package com.candenizgumus.springboot_blog.services;

import com.candenizgumus.springboot_blog.dto.requests.CategorySaveDto;
import com.candenizgumus.springboot_blog.dto.responses.CategoryResponseDto;
import com.candenizgumus.springboot_blog.dto.responses.PostResponseDto;
import com.candenizgumus.springboot_blog.entities.Category;
import com.candenizgumus.springboot_blog.exceptions.BlogAppException;
import com.candenizgumus.springboot_blog.exceptions.ErrorType;
import com.candenizgumus.springboot_blog.mapper.CategoryMapper;
import com.candenizgumus.springboot_blog.mapper.PostMapper;
import com.candenizgumus.springboot_blog.repositories.CategoryRepository;
import com.candenizgumus.springboot_blog.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    /**
     * Nesneyi database'e kaydeder
     * @param dto kaydedilmek istenen DTO nesnesi
     * @return kaydedilen nesneyi geri döndürür
     */
    public Category saveDto(CategorySaveDto dto)
    {
        Category category = CategoryMapper.INSTANCE.categorySaveDtoToCategory(dto);
        return save(category);
    }
    /**
     * Veritabanından isme göre kategoriyi bulur ve getirir.
     * @param name aranan kategorinin ismi.
     * @return kategoriyi döndürür.
     */
    public Category findByNameIgnoreCase(String name){

        return categoryRepository.findByNameIgnoreCase(name).orElseThrow(() -> new BlogAppException(ErrorType.CATEGORY_NOT_FOUND));
    }
    /**
     * Tüm kategorileri veritabanından getirir.
     * @return Veritabanındaki tüm kategorileri içeren bir DTO formatında liste döndürür.
     */
    public List<CategoryResponseDto> findAllDto()
    {
        List<CategoryResponseDto>  newCategoryList = new ArrayList<>();
        categoryRepository.findAll().forEach(category -> newCategoryList.add(CategoryMapper.INSTANCE.categoryToCategoryResponseDto(category)));

        return newCategoryList;
    }
}
