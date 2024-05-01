package com.candenizgumus.springboot_blog.controller;

import com.candenizgumus.springboot_blog.dto.requests.CategorySaveDto;
import com.candenizgumus.springboot_blog.dto.responses.CategoryResponseDto;
import com.candenizgumus.springboot_blog.dto.responses.PostResponseDto;
import com.candenizgumus.springboot_blog.entities.Category;
import com.candenizgumus.springboot_blog.entities.Comment;
import com.candenizgumus.springboot_blog.services.CategoryService;
import com.candenizgumus.springboot_blog.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.candenizgumus.springboot_blog.constants.EndPoints.*;

@RequiredArgsConstructor
@RequestMapping(CATEGORY)
@RestController
public class CategoryController
{
    private final CategoryService categoryService;

    @PostMapping(SAVE)
    public ResponseEntity<Category> save(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.save(category));
    }

    @PostMapping(SAVEDTO)
    public ResponseEntity<Category> saveDto(@RequestBody CategorySaveDto dto){
        return ResponseEntity.ok(categoryService.saveDto(dto));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }
    @GetMapping(FINDBYID)
    public ResponseEntity<Category> findById(Long categoryId){
        return ResponseEntity.ok(categoryService.findById(categoryId).get());
    }
    @GetMapping(FINDALLDTO)
    public ResponseEntity<List<CategoryResponseDto>> findAllDto(){
        return ResponseEntity.ok(categoryService.findAllDto());
    }
    @GetMapping(FINDBYNAMEIGNORECASE)
    public ResponseEntity<Category> findByNameIgnoreCase(String name){
        return ResponseEntity.ok(categoryService.findByNameIgnoreCase(name));
    }

    @PutMapping(UPDATE)
    public ResponseEntity<Category> update(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.save(category));

    }

    @DeleteMapping(DELETE)
    public ResponseEntity<String> delete(Long categoryId){
        categoryService.deleteById(categoryId);
        return ResponseEntity.ok("Basariyla category silindi");

    }




}
