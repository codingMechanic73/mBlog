package com.example.services;

import com.example.beans.Post;

import java.util.List;

public interface PostService {
    List<Post> getPostsByEmailId(String email);

    Post getPostByTag(String tag);

    boolean savePost(Post post);

}
