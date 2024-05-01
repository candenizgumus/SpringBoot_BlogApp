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

    /**
     * Nesneyi database'e kaydeder
     * @param category kaydedilmek istenen nesne
     * @return kaydedilen nesneyi geri döndürür
     */
    @PostMapping(SAVE)
    public ResponseEntity<Category> save(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.save(category));
    }

    /**
     * Nesneyi database'e kaydeder
     * @param dto kaydedilmek istenen DTO nesnesi
     * @return kaydedilen nesneyi geri döndürür
     */
    @PostMapping(SAVEDTO)
    public ResponseEntity<Category> saveDto(@RequestBody CategorySaveDto dto){
        return ResponseEntity.ok(categoryService.saveDto(dto));
    }

    /**
     * Tüm kategorileri veritabanından getirir.
     * @return Veritabanındaki tüm kategorileri içeren bir liste döndürür.
     */
    @GetMapping(FINDALL)
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    /**
     * Database'den id'si verilen kategoriyi getirir.
     * @param categoryId aranan kategorinin id'si.
     * @return kategoriyi döndürür.
     */
    @GetMapping(FINDBYID)
    public ResponseEntity<Category> findById(Long categoryId){
        return ResponseEntity.ok(categoryService.findById(categoryId).get());
    }

    /**
     * Tüm kategorileri veritabanından getirir.
     * @return Veritabanındaki tüm kategorileri içeren bir DTO formatında liste döndürür.
     */
    @GetMapping(FINDALLDTO)
    public ResponseEntity<List<CategoryResponseDto>> findAllDto(){
        return ResponseEntity.ok(categoryService.findAllDto());
    }

    /**
     * Veritabanından isme göre kategoriyi bulur ve getirir.
     * @param name aranan kategorinin ismi.
     * @return kategoriyi döndürür.
     */
    @GetMapping(FINDBYNAMEIGNORECASE)
    public ResponseEntity<Category> findByNameIgnoreCase(String name){
        return ResponseEntity.ok(categoryService.findByNameIgnoreCase(name));
    }

    /**
     * Veritabanındaki ilgili veriyi günceller.
     * @param category güncellenmek istenen nesne
     * @return kategoriyi döndürür.
     */
    @PutMapping(UPDATE)
    public ResponseEntity<Category> update(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.save(category));

    }
    /**
     * Veritabanında id'si verilen veriyi siler.
     * @param categoryId silinecek olan verinin id'si.
     * @return Verinin silindiğine dair onay metni döndürür.
     */
    @DeleteMapping(DELETE)
    public ResponseEntity<String> delete(Long categoryId){
        categoryService.deleteById(categoryId);
        return ResponseEntity.ok("Basariyla category silindi");

    }




}
