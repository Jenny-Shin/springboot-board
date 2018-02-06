package com.example.springboot.board.service;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.springboot.board.domain.posts.Posts;
import com.example.springboot.board.domain.posts.PostsRepository;
import com.example.springboot.board.dto.PostsSaveRequestDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void saveDtoInPostsTable() {
        // GIVEN
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                                                     .author("someone")
                                                     .content("test")
                                                     .title("test title")
                                                     .build();

        // WHEN
        postsService.save(dto);

        // THEN
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
    }
}
