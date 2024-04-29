package com.candenizgumus.springboot_blog.services;

import com.candenizgumus.springboot_blog.dto.requests.LikeSaveDto;
import com.candenizgumus.springboot_blog.entities.Comment;
import com.candenizgumus.springboot_blog.entities.Like;
import com.candenizgumus.springboot_blog.entities.Post;
import com.candenizgumus.springboot_blog.entities.User;
import com.candenizgumus.springboot_blog.exceptions.BlogAppException;
import com.candenizgumus.springboot_blog.exceptions.ErrorType;
import com.candenizgumus.springboot_blog.mapper.LikeMapper;
import com.candenizgumus.springboot_blog.repositories.CommentRepository;
import com.candenizgumus.springboot_blog.repositories.LikeRepository;
import com.candenizgumus.springboot_blog.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LikeService extends ServiceManager<Like,Long>
{
    private final LikeRepository likeRepository;
    private final PostService postService;
    private final UserService userService;


    public LikeService(LikeRepository likeRepository, PostService postService, UserService userService)
    {
        super(likeRepository);
        this.likeRepository = likeRepository;
        this.postService = postService;
        this.userService = userService;
    }


    public Like save(LikeSaveDto dto)
    {
        User user = userService.findById(dto.user()).orElseThrow(() -> new BlogAppException(ErrorType.USER_NOT_FOUND));
        Post post = postService.findById(dto.post()).orElseThrow(() -> new BlogAppException(ErrorType.POST_NOT_FOUND));

        if (likeRepository.existsByUserAndPost(user,post))
        {
            throw new BlogAppException(ErrorType.POST_ALREADY_LIKED);
        }

        increaseLikeCountOfPost(post);

        Like like = Like.builder().user(user).post(post).build();

        return super.save(like);
    }

    private void increaseLikeCountOfPost(Post post){
        post.setLikecount(post.getLikecount()+1);
        postService.save(post);
    }
}
