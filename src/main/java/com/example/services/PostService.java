package com.example.services;

import com.example.beans.Post;
import com.example.exceptions.SomethingWentWrong;

import java.util.List;

public interface PostService {

    boolean savePost(Post post);

    List<Post> getPostByUserName(String userName);

    List<Post> getAllPost();

    List<Post> getPostByTag(String str);

    void deletePost(int PostId, String userName) throws SomethingWentWrong;

    Integer getMaxId();

}
