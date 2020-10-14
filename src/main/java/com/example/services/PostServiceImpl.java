package com.example.services;

import com.example.Dao.DaoFactoryImpl;
import com.example.Dao.PostDao;
import com.example.beans.Post;
import com.example.exceptions.SomethingWentWrong;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PostServiceImpl implements PostService {
    public static PostService postService;
    private static PostDao postDao;

    private static List<Post> posts;

    private PostServiceImpl() {

    }

    public static PostService getInstance() throws SomethingWentWrong {
        if (postService == null) {

            postDao = DaoFactoryImpl.getInstance().getPostDao();
            try {
                postService = new PostServiceImpl();
                posts = postDao.getAllPost();
                Collections.reverse(posts);
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
                throw new SomethingWentWrong("Something went wrong!");
            }
        }
        return postService;
    }

    @Override
    public List<Post> getAllPost() {
        return posts;
    }

    @Override
    public List<Post> getPostByTag(String str) {
        return posts.stream().filter(post -> post.getTag().equals(str)).collect(Collectors.toList());
    }

    @Override
    public void deletePost(int postId, String userName) {

        for (Post post : posts) {
            if (post.getPostId() == postId && post.getUserName().equals(userName)) {

                new Thread(() -> {
                    try {
                        postDao.deletePost(postId);
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }).start();
                posts.remove(post);
                break;
            }
        }


    }

    @Override
    public Integer getMaxId() {
        try {
            return postDao.getMaxId();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<Post> getPostByUserName(String email) {
        return posts.stream().filter(post -> post.getUserName().equals(email)).collect(Collectors.toList());
    }


    @Override
    public boolean savePost(Post post) {
        posts.add(0,post);
        new Thread(() -> {
            try {
                postDao.savePost(post);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }).start();
        return true;
    }
}
