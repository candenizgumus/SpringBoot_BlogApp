package com.candenizgumus.springboot_blog.controller;

import com.candenizgumus.springboot_blog.dto.requests.LikeSaveDto;
import com.candenizgumus.springboot_blog.entities.Comment;
import com.candenizgumus.springboot_blog.entities.Like;
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

    @PostMapping(SAVE)
    public ResponseEntity<Like> save(@RequestBody LikeSaveDto dto){
        return ResponseEntity.ok(likeService.save(dto));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<Like>> findAll(){
        return ResponseEntity.ok(likeService.findAll());
    }


}
