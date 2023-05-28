package com.pedro.crudblog.core.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pedro.crudblog.core.exception.PostNotFoundException;
import com.pedro.crudblog.core.models.dto.PostRequestDto;
import com.pedro.crudblog.core.models.dto.PostResponseDto;
import com.pedro.crudblog.core.models.entity.Post;
import com.pedro.crudblog.core.repository.PostRepository;
import com.pedro.crudblog.core.service.PostService;

@Service
public class PostServiceImpl implements PostService {

        private PostRepository postRepository;

        public PostServiceImpl(PostRepository postRepository) {
                this.postRepository = postRepository;
        }

        @Override
        public PostResponseDto create(PostRequestDto postRequestDto) {
                Post post = this.postRepository.save(
                                Post.builder()
                                                .mensage(postRequestDto.getMensage())
                                                .creationDate(LocalDateTime.now())
                                                .build());
                return PostResponseDto.builder()
                                .id(post.getId())
                                .mensage(post.getMensage())
                                .creationDate(post.getCreationDate())
                                .build();
        }

        @Override
        public List<PostResponseDto> readAll() {
                return this.postRepository.findAll().stream().map(
                                p -> PostResponseDto.builder()
                                                .id(p.getId())
                                                .mensage(p.getMensage())
                                                .creationDate(p.getCreationDate())
                                                .build())
                                .collect(Collectors.toList());
        }

        @Override
        public PostResponseDto readOnly(Long id) {
                Post post = this.postRepository.findById(id)
                                .orElseThrow(() -> new PostNotFoundException("Post id: " + id + " não encontrado."));
                return new PostResponseDto(post);
        }

        @Override
        public PostResponseDto update(Long id, PostRequestDto postRequestDto) {
                Post post = this.postRepository.findById(id)
                                .orElseThrow(() -> new PostNotFoundException("Post id: " + id + " não encontrado."));
                post.setMensage(postRequestDto.getMensage());
                this.postRepository.save(post);
                return PostResponseDto.builder()
                                .id(post.getId())
                                .mensage(post.getMensage())
                                .creationDate(post.getCreationDate())
                                .build();
        }

        @Override
        public void delete(Long id) {
                Post post = this.postRepository.findById(id)
                                .orElseThrow(() -> new PostNotFoundException("Post id: " + id + " não encontrado."));
                this.postRepository.delete(post);
        }

}
