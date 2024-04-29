package com.candenizgumus.springboot_blog.repositories;

import com.candenizgumus.springboot_blog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>
{
}
