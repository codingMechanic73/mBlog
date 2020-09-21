package com.example.services;

import com.example.Dao.DaoFactoryImpl;
import com.example.Dao.PostDao;
import com.example.beans.Post;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostServiceImpl implements PostService {
    public static PostService postService;
    private static PostDao postDao;

    private static List<Post> posts = new ArrayList<>();

    private PostServiceImpl() throws SQLException, ClassNotFoundException {
        posts = postDao.getAllPost();
    }

    public static PostService getInstance() {
        if (postService == null) {
            postDao = DaoFactoryImpl.getInstance().getPostDao();
            try {
                postService = new PostServiceImpl();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return postService;
    }

    @Override
    public List<Post> getAllPost() {
        return posts;
    }

    @Override
    public List<Post> getPostByUserName(String email) {
        return posts.stream().filter(post -> post.getUserName().equals(email)).collect(Collectors.toList());
    }

    @Override
    public List<Post> getPostBasedOnSearch(String str) {
        return posts.stream().filter(post -> post.getTitle().contains(str)).collect(Collectors.toList());
    }

    @Override
    public boolean savePost(Post post) {
        posts.add(post);
        System.out.println("Post added");
        new Thread(() ->  {
            try {
                postDao.savePost(post);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }).start();
        return true;
    }
}
