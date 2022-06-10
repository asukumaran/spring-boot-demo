package com.example.demo.service;

import com.example.demo.dto.Post;
import com.example.demo.dto.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    List<Post> getPosts();

    List<User> getAllPostsById();

}
