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
    public List<Post> getPostsByEmailId(String email) throws SQLException, ClassNotFoundException {
//        Connection connection = DatabaseConnection.getConnection();
//        Statement statement = connection.createStatement();
//        String query = "SELECT postId, postBy, title, tag, description, timestamp from Posts where email = \"" + email + "\";";
//        ResultSet rs = statement.executeQuery(query);
//        List<Post> posts = new ArrayList<>();
//        while (rs.next()) {
//            Post post = new Post();
//            post.setPostId(rs.getInt("postId"));
//            post.setPostBy(rs.getString("postBy"));
//            post.setTitle(rs.getString("title"));
//            post.setTag(rs.getString("tag"));
//            post.setDescription(rs.getString("description"));
//            post.setTimestamp(LocalDateTime.now());
//            posts.add(post);
//        }
//        return posts;
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Post post = new Post();
            post.setPostId(1);
            post.setPostBy("hi");
            post.setTitle("title");
            post.setTag("tag");
            post.setDescription("This is a description");
            post.setTimestamp(LocalDateTime.now());
            posts.add(post);
        }
        return posts;
    }

    @Override
    public Post getPostByTag(String tag) throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT postId, postBy, title, tag, description, timestamp from Posts where tag = \"" + tag + "\";";
        ResultSet rs = statement.executeQuery(query);
        Post post = null;
        while (rs.next()) {
            post = new Post();
            post.setPostId(rs.getInt("postId"));
            post.setPostBy(rs.getString("postBy"));
            post.setTitle(rs.getString("title"));
            post.setTag(rs.getString("tag"));
            post.setDescription(rs.getString("description"));
            post.setTimestamp(LocalDateTime.now());
        }
        return post;
    }

    @Override
    public int savePost(Post post) throws SQLException, ClassNotFoundException {
//        Connection connection = DatabaseConnection.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Posts values(?, ?, ?, ?, ?)");
//        preparedStatement.setInt(1, post.getPostId());
//        preparedStatement.setString(2, post.getPostBy());
//        preparedStatement.setString(3, post.getTitle());
//        preparedStatement.setString(4, post.getTags());
//        preparedStatement.setString(5, post.getDescription());
//        preparedStatement.setString(6, post.getTimestamp().toString());
//        return preparedStatement.executeUpdate();
        return 1;
    }
}
