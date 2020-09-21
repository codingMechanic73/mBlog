package com.example.Dao;

import com.example.beans.Post;
import com.example.database.DatabaseConnection;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostDaoImpl implements PostDao {

    private static PostDao postDao;

    private PostDaoImpl() {
    }

    public static PostDao getInstance() {
        if (postDao == null) {
            postDao = new PostDaoImpl();
        }
        return postDao;
    }

    @Override
    public List<Post> getPostsByEmailId(String userName) throws SQLException, ClassNotFoundException {
        return new ArrayList<>();
    }

    @Override
    public Post getPostByTag(String tag) throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT postId, postBy, title, tag, description, timestamp from mblog.Post where tag = \"" + tag + "\";";
        ResultSet rs = statement.executeQuery(query);
        Post post = null;
        while (rs.next()) {
            post = new Post();
            post.setPostId(rs.getInt("postId"));
            post.setUserName(rs.getString("postBy"));
            post.setTitle(rs.getString("title"));
            post.setTag(rs.getString("tag"));
            post.setDescription(rs.getString("description"));
            post.setTimestamp(LocalDateTime.now());
        }
        return post;
    }

    @Override
    public int savePost(Post post) throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO mblog.Post(title, tag, description, timestamp, userName, imgUrl) values(?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, post.getTitle());
        preparedStatement.setString(2, post.getTag());
        preparedStatement.setString(3, post.getDescription());
        preparedStatement.setString(4, "fiej");
        preparedStatement.setString(5, post.getUserName());
        preparedStatement.setString(6, post.getImgUrl());
        return preparedStatement.executeUpdate();
    }

    @Override
    public List<Post> getAllPost() throws SQLException, ClassNotFoundException {
        List<Post> posts = new ArrayList<>();
        String query = "SELECT title, tag, description, imgUrl, userName, postId, timestamp from mblog.Post";
        Connection con = DatabaseConnection.getInstance().getConnection();
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Post post = new Post(rs.getInt("postId"),rs.getString("imgUrl"),rs.getString("userName"), rs.getString("title"), rs.getString("tag"), rs.getString("description"), LocalDateTime.now());
            posts.add(post);
        }
        return posts;
    }
}
