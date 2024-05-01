package com.candenizgumus.springboot_blog.dto.responses;

import java.time.LocalDateTime;

public record PostResponseDto(String title, String context, LocalDateTime publishdate,Integer likecount)
{
}
