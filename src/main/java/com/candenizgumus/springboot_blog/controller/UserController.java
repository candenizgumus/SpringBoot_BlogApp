package com.candenizgumus.springboot_blog.controller;

import static com.candenizgumus.springboot_blog.constants.EndPoints.*;

import com.candenizgumus.springboot_blog.dto.responses.UserResponseDto;
import com.candenizgumus.springboot_blog.entities.User;
import com.candenizgumus.springboot_blog.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping(USER)
@RestController
public class UserController
{
    private final UserService userService;

    @PostMapping(SAVE)
    public ResponseEntity<User> save(@Valid @RequestBody  User user){
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping(FINDALLDTO)
    public ResponseEntity<List<UserResponseDto>> findAllDto(){
        return ResponseEntity.ok(userService.findAllDto());
    }

    @GetMapping(FINDBYID)
    public ResponseEntity<User> findById(Long userId){
        return ResponseEntity.ok(userService.findById(userId).get());
    }

    @PutMapping(UPDATE)
    public ResponseEntity<User> update(@RequestBody User user){
       return ResponseEntity.ok(userService.save(user));

    }

    @DeleteMapping(DELETE)
    public ResponseEntity<String> delete(Long userId){
        userService.deleteById(userId);
        return ResponseEntity.ok("Basariyla user silindi");

    }
}
