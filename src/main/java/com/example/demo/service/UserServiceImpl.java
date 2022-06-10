package com.example.demo.service;

import com.example.demo.dto.Post;
import com.example.demo.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<User> getUsers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        User[] users = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users",
                User[].class);

        return Arrays.asList(users);
    }

    @Override
    public List<Post> getPosts() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        Post[] posts = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts",
                Post[].class);

        return Arrays.asList(posts);
    }

    @Override
    public List<User> getAllPostsById() {
        List<User> users = this.getUsers();
        Map<Long, List<Post>> postsPerUserId = this.getPosts().stream().collect(Collectors.groupingBy(
                Post::getUserId));
        users.stream().forEach(t -> {
            List<Post> userPost = postsPerUserId.get(t.getId());
            t.setPost(userPost);
        });
        return users;
    }
}

class UserList {
    private List<User> users;

    public UserList() {
        users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}