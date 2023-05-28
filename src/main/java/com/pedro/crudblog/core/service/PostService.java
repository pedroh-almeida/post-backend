package com.pedro.crudblog.core.service;

import java.util.List;

import com.pedro.crudblog.core.models.dto.PostRequestDto;
import com.pedro.crudblog.core.models.dto.PostResponseDto;

public interface PostService {

    public PostResponseDto create(PostRequestDto postRequestDto);

    public List<PostResponseDto> readAll();

    public PostResponseDto readOnly(Long id);

    public PostResponseDto update(Long id, PostRequestDto postRequestDto);

    public void delete(Long id);

}
