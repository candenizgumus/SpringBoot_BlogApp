package com.candenizgumus.springboot_blog.repositories;

import com.candenizgumus.springboot_blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>
{
}
