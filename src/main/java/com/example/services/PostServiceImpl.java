package com.example.services;

import com.example.Dao.DaoFactoryImpl;
import com.example.Dao.PostDao;
import com.example.beans.Post;

import java.sql.SQLException;
import java.util.List;

public class PostServiceImpl implements PostService {
    public static PostService postService;
    private static PostDao postDao;

    private PostServiceImpl() {
    }

    public static PostService getInstance() {
        if (postService == null) {
            postDao = DaoFactoryImpl.getInstance().getPostDao();
        }
        return postService;
    }

    @Override
    public List<Post> getPostsByEmailId(String email) {
        try {
            return postDao.getPostsByEmailId(email);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Post getPostByTag(String tag) {
        try {
            return postDao.getPostByTag(tag);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean savePost(Post post) {
        try {
            postDao.savePost(post);
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
