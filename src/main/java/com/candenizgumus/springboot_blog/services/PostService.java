package com.candenizgumus.springboot_blog.services;

import com.candenizgumus.springboot_blog.dto.responses.PostResponseDto;
import com.candenizgumus.springboot_blog.dto.responses.UserResponseDto;
import com.candenizgumus.springboot_blog.entities.Category;
import com.candenizgumus.springboot_blog.entities.Post;
import com.candenizgumus.springboot_blog.mapper.PostMapper;
import com.candenizgumus.springboot_blog.mapper.UserMapper;
import com.candenizgumus.springboot_blog.repositories.CategoryRepository;
import com.candenizgumus.springboot_blog.repositories.PostRepository;
import com.candenizgumus.springboot_blog.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService extends ServiceManager<Post,Long>
{
    private final PostRepository postRepository;


    public PostService(PostRepository postRepository)
    {
        super(postRepository);
        this.postRepository = postRepository;
    }
    /**
     * Veri tabanından bütün postları yayın tarihine göre sıralı şekilde getirir.
     * @return Tüm postları liste şeklinde döndürür.
     */
    public List<Post> findAllByOrderByPublishdateDesc(){
        return postRepository.findAllByOrderByPublishdateDesc();
    }

    /**
     * Veri tabanından category id'si ile eşleşen bütün postları döndürür.
     * @param categoryId aranan kategorinin id'si.
     * @return Bütün postları liste şeklinde döndürür.
     */
    public List<Post> findAllByCategory_Id(Long categoryId){
        return postRepository.findAllByCategory_Id(categoryId);
    }

    /**
     * Veri tabanından user id ile eşleşen bütün postları getirir.
     * @param userId aranan user'ın id'si.
     * @return Bulunan bütün postları liste şeklinde döndürür.
     */
    public List<Post> findAllByUser_Id(Long userId){
        return postRepository.findAllByUser_Id(userId);
    }
    /**
     * Tüm postları veritabanından getirir.
     * @return Veritabanındaki tüm Postları içeren bir DTO formatında liste döndürür.
     */
    public List<PostResponseDto> findAllDto()
    {
        List<PostResponseDto>  newPostList = new ArrayList<>();
        postRepository.findAll().forEach(post -> newPostList.add(PostMapper.INSTANCE.postToPostResponseDto(post)));

        return newPostList;
    }
    /**
     * Veritabanından aranan kelime içinde bulunan bütün postları getirir.
     * @param searchedWord aranan kelime
     * @return Bulunan bütün postları liste şeklinde döndürür.
     */
    public List<Post> findAllByContextContainingIgnoreCase(String searchedWord){
        return postRepository.findAllByContextContainingIgnoreCase(searchedWord);
    }
}
