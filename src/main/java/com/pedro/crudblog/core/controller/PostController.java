package com.pedro.crudblog.core.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.crudblog.core.models.dto.PostRequestDto;
import com.pedro.crudblog.core.models.dto.PostResponseDto;
import com.pedro.crudblog.core.service.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<PostResponseDto>> readAll() {
        return new ResponseEntity<>(this.postService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> readOnly(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.postService.readOnly(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostResponseDto> create(@Valid @RequestBody PostRequestDto postRequestDto) {
        return new ResponseEntity<>(this.postService.create(postRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDto> update(@PathVariable("id") Long id,
            @Valid @RequestBody PostRequestDto postRequestDto) {
        return new ResponseEntity<>(this.postService.update(id, postRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        this.postService.delete(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}
