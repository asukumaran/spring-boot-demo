package com.example.demo.service;

import com.example.demo.DemoApplicationTests;
import com.example.demo.dto.Post;
import com.example.demo.dto.User;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestUserService extends DemoApplicationTests {
    @Autowired
    private UserService userService;

    @Before
    public void setup() {
    }

    @Test
    public void should_get_user_details() throws Exception{
        List<User> users = userService.getUsers();
        assertTrue(users.size() > 0);
        assertNotNull(users.stream().findAny().get().getId());
    }

    @Test
    public void should_get_posts_by_user() throws Exception{
        List<User> users = userService.getAllPostsById();
        assertTrue(users.size() > 0);
        assertNotNull(users.stream().findAny().get().getId());
    }

    @Test
    public void should_get_post_details() throws Exception{
        List<Post> posts = userService.getPosts();
        assertTrue(posts.size() > 0);
        assertNotNull(posts.stream().findAny().get().getId());
    }

}
