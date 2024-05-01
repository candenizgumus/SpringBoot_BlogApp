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

    /**
     * Nesneyi database'e kaydeder
     * @param user kaydedilmek istenen nesne
     * @return kaydedilen nesneyi geri döndürür
     */
    @PostMapping(SAVE)
    public ResponseEntity<User> save(@Valid @RequestBody  User user){
        return ResponseEntity.ok(userService.save(user));
    }

    /**
     * Tüm userları veritabanından getirir.
     * @return Veritabanındaki tüm Userları içeren bir liste döndürür.
     */
    @GetMapping(FINDALL)
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    /**
     * Tüm userları veritabanından getirir.
     * @return Veritabanındaki tüm Userları içeren bir DTO formatında liste döndürür.
     */
    @GetMapping(FINDALLDTO)
    public ResponseEntity<List<UserResponseDto>> findAllDto(){
        return ResponseEntity.ok(userService.findAllDto());
    }

    /**
     * Veritabanından id ile eşleşen user'ı getirir.
     * @param userId aranan user'ın id'si.
     * @return User'ı döndürür.
     */
    @GetMapping(FINDBYID)
    public ResponseEntity<User> findById(Long userId){
        return ResponseEntity.ok(userService.findById(userId).get());
    }

    /**
     * Veritabanındaki ilgili veriyi günceller.
     * @param user güncellenmek istenen nesne
     * @return user'ı döndürür.
     */
    @PutMapping(UPDATE)
    public ResponseEntity<User> update(@RequestBody User user){
       return ResponseEntity.ok(userService.save(user));

    }

    /**
     * Veritabanında id'si verilen veriyi siler.
     * @param userId silinecek olan verinin id'si.
     * @return Verinin silindiğine dair onay metni döndürür.
     */
    @DeleteMapping(DELETE)
    public ResponseEntity<String> delete(Long userId){
        userService.deleteById(userId);
        return ResponseEntity.ok("Basariyla user silindi");

    }
}
