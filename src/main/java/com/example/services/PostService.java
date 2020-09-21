package com.example.services;

import com.example.beans.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPost();

    List<Post> getPostByUserName(String userName);

    List<Post> getPostBasedOnSearch(String str);

    boolean savePost(Post post);

}
