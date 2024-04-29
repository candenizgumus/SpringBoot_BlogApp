package com.candenizgumus.springboot_blog.repositories;

import com.candenizgumus.springboot_blog.entities.Category;
import com.candenizgumus.springboot_blog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long>
{
    List<Post> findAllByOrderByPublishdateDesc();
    List<Post> findAllByCategory_Id(Long categoryId);

    List<Post> findAllByUser_Id(Long userId);

}
