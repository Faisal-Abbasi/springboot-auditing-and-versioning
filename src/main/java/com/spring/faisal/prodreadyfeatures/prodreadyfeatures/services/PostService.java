package com.spring.faisal.prodreadyfeatures.prodreadyfeatures.services;

import com.spring.faisal.prodreadyfeatures.prodreadyfeatures.dto.PostDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {
    List<PostDTO> getAllPosts();
    PostDTO createNewPost(PostDTO inputPost);

    PostDTO getPostById(Long postId);

    PostDTO updatePost(PostDTO inputPost, Long postId);
}
