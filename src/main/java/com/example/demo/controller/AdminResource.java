package com.example.demo.controller;

import com.example.demo.dto.Post;
import com.example.demo.dto.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class AdminResource {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users" , method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/posts" , method = RequestMethod.GET)
    public List<Post> getPosts() {
        return userService.getPosts();
    }

    @RequestMapping(value = "/admin/users" , method = RequestMethod.GET)
    public List<User> getAllPostsById() {
        return userService.getAllPostsById();
    }

}
