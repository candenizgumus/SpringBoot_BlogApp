package com.candenizgumus.springboot_blog.controller;

import com.candenizgumus.springboot_blog.entities.Category;
import com.candenizgumus.springboot_blog.entities.Post;
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
}
