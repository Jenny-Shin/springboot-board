package com.example.springboot.board.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.springboot.board.domain.posts.PostsRepository;
import com.example.springboot.board.dto.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {

    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }
}
