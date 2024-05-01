package com.candenizgumus.springboot_blog.controller;

import com.candenizgumus.springboot_blog.dto.responses.PostResponseDto;
import com.candenizgumus.springboot_blog.dto.responses.UserResponseDto;
import com.candenizgumus.springboot_blog.entities.Category;
import com.candenizgumus.springboot_blog.entities.Post;
import com.candenizgumus.springboot_blog.entities.User;
import com.candenizgumus.springboot_blog.services.CategoryService;
import com.candenizgumus.springboot_blog.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.candenizgumus.springboot_blog.constants.EndPoints.*;
import static com.candenizgumus.springboot_blog.constants.EndPoints.FINDALL;

@RequiredArgsConstructor
@RequestMapping(POST)
@RestController
public class PostController
{
    private final PostService postService;

    /**
     * Nesneyi database'e kaydeder
     * @param post kaydedilmek istenen nesne
     * @return kaydedilen nesneyi geri döndürür
     */
    @PostMapping(SAVE)
    public ResponseEntity<Post> save(@RequestBody Post post){
        return ResponseEntity.ok(postService.save(post));
    }

    /**
     * Tüm postları veritabanından getirir.
     * @return Veritabanındaki tüm Postları içeren bir liste döndürür.
     */
    @GetMapping(FINDALL)
    public ResponseEntity<List<Post>> findAll(){
        return ResponseEntity.ok(postService.findAll());
    }


    /**
     * Veritabanından id'si verilen veriyi getirir.
     * @param postId aranan post id'si
     * @return bulunan postu döndürür.
     */
    @GetMapping(FINDBYID)
    public ResponseEntity<Post> findById(Long postId){
        return ResponseEntity.ok(postService.findById(postId).get());
    }

    /**
     * Tüm postları veritabanından getirir.
     * @return Veritabanındaki tüm Postları içeren bir DTO formatında liste döndürür.
     */
    @GetMapping(FINDALLDTO)
    public ResponseEntity<List<PostResponseDto>> findAllDto(){
        return ResponseEntity.ok(postService.findAllDto());
    }

    /**
     * Veri tabanından bütün postları yayın tarihine göre sıralı şekilde getirir.
     * @return Tüm postları liste şeklinde döndürür.
     */
    @GetMapping(FINDALLBYPUBLISHDATE)
    public ResponseEntity<List<Post>> findAllByOrderByPublishdateDesc(){
        return ResponseEntity.ok(postService.findAllByOrderByPublishdateDesc());
    }

    /**
     * Veri tabanından category id'si ile eşleşen bütün postları döndürür.
     * @param categoryId aranan kategorinin id'si.
     * @return Bütün postları liste şeklinde döndürür.
     */
    @GetMapping(FINDALLBYCATEGORYID+"/{categoryId}")
    public ResponseEntity<List<Post>> findAllByCategory_Id(@PathVariable Long categoryId){
        return ResponseEntity.ok(postService.findAllByCategory_Id(categoryId));
    }

    /**
     * Veri tabanından user id ile eşleşen bütün postları getirir.
     * @param userId aranan user'ın id'si.
     * @return Bulunan bütün postları liste şeklinde döndürür.
     */
    @GetMapping(FINDALLBYUSERID)
    public ResponseEntity<List<Post>> findAllByUser_Id(Long userId){
        return ResponseEntity.ok(postService.findAllByUser_Id(userId));
    }

    /**
     * Veritabanından aranan kelime içinde bulunan bütün postları getirir.
     * @param searchedWord aranan kelime
     * @return Bulunan bütün postları liste şeklinde döndürür.
     */
    @GetMapping(FINDALLBYCONTEXTCONTAINING)
    public ResponseEntity<List<Post>> findAllByContextContainingIgnoreCase(String searchedWord){
        return ResponseEntity.ok(postService.findAllByContextContainingIgnoreCase(searchedWord));
    }

    /**
     * Veritabanındaki ilgili veriyi günceller.
     * @param post güncellenmek istenen nesne
     * @return post'u döndürür.
     */
    @PutMapping(UPDATE)
    public ResponseEntity<Post> update(@RequestBody Post post){
        return ResponseEntity.ok(postService.save(post));

    }
    /**
     * Veritabanında id'si verilen veriyi siler.
     * @param postId silinecek olan verinin id'si.
     * @return Verinin silindiğine dair onay metni döndürür.
     */
    @DeleteMapping(DELETE)
    public ResponseEntity<String> delete(Long postId){
        postService.deleteById(postId);
        return ResponseEntity.ok("Basariyla post silindi");

    }
}
