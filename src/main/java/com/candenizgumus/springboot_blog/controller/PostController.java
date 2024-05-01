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

    @PostMapping(SAVE)
    public ResponseEntity<Post> save(@RequestBody Post post){
        return ResponseEntity.ok(postService.save(post));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<Post>> findAll(){
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping(FINDBYID)
    public ResponseEntity<Post> findById(Long postId){
        return ResponseEntity.ok(postService.findById(postId).get());
    }

    @GetMapping(FINDALLDTO)
    public ResponseEntity<List<PostResponseDto>> findAllDto(){
        return ResponseEntity.ok(postService.findAllDto());
    }
    @GetMapping(FINDALLBYPUBLISHDATE)
    public ResponseEntity<List<Post>> findAllByOrderByPublishdateDesc(){
        return ResponseEntity.ok(postService.findAllByOrderByPublishdateDesc());
    }

    @GetMapping(FINDALLBYCATEGORYID+"/{categoryId}")
    public ResponseEntity<List<Post>> findAllByCategory_Id(@PathVariable Long categoryId){
        return ResponseEntity.ok(postService.findAllByCategory_Id(categoryId));
    }

    @GetMapping(FINDALLBYUSERID)
    public ResponseEntity<List<Post>> findAllByUser_Id(Long userId){
        return ResponseEntity.ok(postService.findAllByUser_Id(userId));
    }
    @GetMapping(FINDALLBYCONTEXTCONTAINING)
    public ResponseEntity<List<Post>> findAllByContextContainingIgnoreCase(String searchedWord){
        return ResponseEntity.ok(postService.findAllByContextContainingIgnoreCase(searchedWord));
    }

    @PutMapping(UPDATE)
    public ResponseEntity<Post> update(@RequestBody Post post){
        return ResponseEntity.ok(postService.save(post));

    }

    @DeleteMapping(DELETE)
    public ResponseEntity<String> delete(Long postId){
        postService.deleteById(postId);
        return ResponseEntity.ok("Basariyla post silindi");

    }
}
