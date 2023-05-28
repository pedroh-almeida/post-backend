package com.pedro.crudblog.core.models.dto;

import java.time.LocalDateTime;

import com.pedro.crudblog.core.models.entity.Post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDto {

    private Long id;

    @NotNull(message = "A mensagem do post não pode ser nula.")
    @NotBlank(message = "A mensagem do post não pode ser vázia.")
    private String mensage;

    private LocalDateTime creationDate;

    public Post toEntity() {

        return Post.builder()
                .mensage(mensage)
                .creationDate(LocalDateTime.now())
                .build();
    }

}
