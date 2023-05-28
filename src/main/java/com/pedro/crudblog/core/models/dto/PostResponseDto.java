package com.pedro.crudblog.core.models.dto;

import java.time.LocalDateTime;

import com.pedro.crudblog.core.models.entity.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {

    private Long id;

    private String mensage;

    private LocalDateTime creationDate;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.mensage = post.getMensage();
        this.creationDate = post.getCreationDate();
    }

}
