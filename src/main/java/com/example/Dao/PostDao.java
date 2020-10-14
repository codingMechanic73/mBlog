package com.example.Dao;

import com.example.beans.Post;


import java.sql.SQLException;
import java.util.List;

public interface PostDao {

    int savePost(Post post) throws SQLException, ClassNotFoundException;

    List<Post> getAllPost() throws SQLException, ClassNotFoundException;

    Integer getMaxId() throws SQLException, ClassNotFoundException;

    void deletePost(int id) throws SQLException, ClassNotFoundException;
}
