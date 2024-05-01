package com.candenizgumus.springboot_blog.controller;

import com.candenizgumus.springboot_blog.dto.responses.CommentResponseDto;
import com.candenizgumus.springboot_blog.dto.responses.PostResponseDto;
import com.candenizgumus.springboot_blog.entities.Category;
import com.candenizgumus.springboot_blog.entities.Comment;
import com.candenizgumus.springboot_blog.entities.Like;
import com.candenizgumus.springboot_blog.services.CategoryService;
import com.candenizgumus.springboot_blog.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.candenizgumus.springboot_blog.constants.EndPoints.*;

@RequiredArgsConstructor
@RequestMapping(COMMENT)
@RestController
public class CommentController
{
    private final CommentService commentService;

    /**
     * Nesneyi database'e kaydeder
     * @param comment kaydedilmek istenen nesne
     * @return kaydedilen nesneyi geri döndürür
     */
    @PostMapping(SAVE)
    public ResponseEntity<Comment> save(@RequestBody Comment comment){
        return ResponseEntity.ok(commentService.save(comment));
    }

    /**
     * Tüm commentleri veritabanından getirir.
     * @return Veritabanındaki tüm commentleri içeren bir liste döndürür.
     */
    @GetMapping(FINDALL)
    public ResponseEntity<List<Comment>> findAll(){
        return ResponseEntity.ok(commentService.findAll());
    }

    @GetMapping(FINDBYID)
    public ResponseEntity<Comment> findById(Long commentId){
        return ResponseEntity.ok(commentService.findById(commentId).get());
    }
    /**
     * Tüm commentleri veritabanından getirir.
     * @return Veritabanındaki tüm commentleri içeren bir DTO formatında liste döndürür.
     */
    @GetMapping(FINDALLDTO)
    public ResponseEntity<List<CommentResponseDto>> findAllDto(){
        return ResponseEntity.ok(commentService.findAllDto());
    }

    /**
     * Veritabanındaki ilgili veriyi günceller.
     * @param comment güncellenmek istenen nesne
     * @return commenti döndürür.
     */
    @PutMapping(UPDATE)
    public ResponseEntity<Comment> update(@RequestBody Comment comment){
        return ResponseEntity.ok(commentService.save(comment));

    }
    /**
     * Veritabanında id'si verilen veriyi siler.
     * @param commentId silinecek olan verinin id'si.
     * @return Verinin silindiğine dair onay metni döndürür.
     */
    @DeleteMapping(DELETE)
    public ResponseEntity<String> delete(Long commentId){
        commentService.deleteById(commentId);
        return ResponseEntity.ok("Basariyla comment silindi");

    }

}
