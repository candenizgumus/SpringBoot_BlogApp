package com.candenizgumus.springboot_blog.controller;

import com.candenizgumus.springboot_blog.dto.requests.LikeSaveDto;
import com.candenizgumus.springboot_blog.dto.responses.LikeResponseDto;
import com.candenizgumus.springboot_blog.dto.responses.PostResponseDto;
import com.candenizgumus.springboot_blog.entities.Comment;
import com.candenizgumus.springboot_blog.entities.Like;
import com.candenizgumus.springboot_blog.entities.Post;
import com.candenizgumus.springboot_blog.entities.User;
import com.candenizgumus.springboot_blog.services.CommentService;
import com.candenizgumus.springboot_blog.services.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.candenizgumus.springboot_blog.constants.EndPoints.*;

@RequiredArgsConstructor
@RequestMapping(LIKE)
@RestController
public class LikeController
{
    private final LikeService likeService;

    /**
     * Nesneyi database'e kaydeder
     * @param dto kaydedilmek istenen nesne
     * @return kaydedilen nesneyi geri döndürür
     */
    @PostMapping(SAVE)
    public ResponseEntity<Like> save(@RequestBody LikeSaveDto dto){
        return ResponseEntity.ok(likeService.save(dto));
    }

    /**
     * Tüm likeları veritabanından getirir.
     * @return Veritabanındaki tüm likeları içeren bir liste döndürür.
     */
    @GetMapping(FINDALL)
    public ResponseEntity<List<Like>> findAll(){
        return ResponseEntity.ok(likeService.findAll());
    }

    /**
     * Veritabanında id'si verilen veriyi getirir.
     * @param likeId aranan like id'si.
     * @return bulunan like'ı döndürür.
     */
    @GetMapping(FINDBYID)
    public ResponseEntity<Like> findById(Long likeId){
        return ResponseEntity.ok(likeService.findById(likeId).get());
    }
    /**
     * Tüm likeları veritabanından getirir.
     * @return Veritabanındaki tüm likeları içeren bir DTO formatında liste döndürür.
     */
    @GetMapping(FINDALLDTO)
    public ResponseEntity<List<LikeResponseDto>> findAllDto(){
        return ResponseEntity.ok(likeService.findAllDto());
    }

    /**
     * Veritabanındaki ilgili veriyi günceller.
     * @param like güncellenmek istenen nesne
     * @return like'ı döndürür.
     */
    @PutMapping(UPDATE)
    public ResponseEntity<Like> update(@RequestBody Like like){
        return ResponseEntity.ok(likeService.save(like));

    }
    /**
     * Veritabanında id'si verilen veriyi siler.
     * @param likeId silinecek olan verinin id'si.
     * @return Verinin silindiğine dair onay metni döndürür.
     */
    @DeleteMapping(DELETE)
    public ResponseEntity<String> delete(Long likeId){
        likeService.deleteById(likeId);
        return ResponseEntity.ok("Basariyla like silindi");

    }
}
