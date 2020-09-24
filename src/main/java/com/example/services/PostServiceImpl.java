package com.example.services;

import com.example.Dao.DaoFactoryImpl;
import com.example.Dao.PostDao;
import com.example.beans.Post;
import com.example.exceptions.SomethingWentWrong;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostServiceImpl implements PostService {
    public static PostService postService;
    private static PostDao postDao;

    private static List<Post> posts;

    private PostServiceImpl() throws SQLException, ClassNotFoundException {
        posts = postDao.getAllPost();
        posts = new ArrayList<>();
        for (int i = 0; i < 34; i++) {
            posts.add(new Post(i, "alfan", "alan123", "title" + i, "tag" + i, "a" + i, LocalDateTime.now()));
        }
    }

    public static PostService getInstance() throws SomethingWentWrong {
        if (postService == null) {
            postDao = DaoFactoryImpl.getInstance().getPostDao();
            try {
                postService = new PostServiceImpl();
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
    public List<Post> getPostByUserName(String email) {
        return posts.stream().filter(post -> post.getUserName().equals(email)).collect(Collectors.toList());
    }


    @Override
    public boolean savePost(Post post) {
        posts.add(post);
        System.out.println("Post added");
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
