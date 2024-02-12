package com.jdbc.test.demo.mapper;

import com.jdbc.test.demo.entity.Post;
import com.jdbc.test.demo.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;


public class PostMapper implements RowMapper<Post> {

    @Override
    public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setId(rs.getInt("id"));
        post.setTitle(rs.getString("title"));
        post.setBody(rs.getString("body"));

        User user = new User();
        user.setId(rs.getInt("user_id"));
        post.setUser(user);

        Timestamp dateCreatedTimestamp = rs.getTimestamp("date_created");
        Timestamp dateModifiedTimestamp = rs.getTimestamp("date_modified");

        post.setDateCreated(dateCreatedTimestamp != null ? dateCreatedTimestamp.toLocalDateTime() : null);
        post.setDateModified(dateModifiedTimestamp != null ? dateModifiedTimestamp.toLocalDateTime() : null);

        return post;
    }
}
