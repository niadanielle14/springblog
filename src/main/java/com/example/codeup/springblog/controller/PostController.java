package com.example.codeup.springblog.controller;

import com.example.codeup.springblog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {
    @GetMapping( "/posts")
    @ResponseBody
    public String posts() {
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    public String postsId(@PathVariable long id, Model vModel) {
        Post post = new Post(
                1,
                "This is Post #" + id,
                "Here are things about the post..."
        );

        vModel.addAttribute("post", post);
        return id + "view an individual post";
    }
    @GetMapping("/posts/create")
    @ResponseBody
    public String postsCreate() {
        return "view the form for creating a post";
    }
    @PostMapping("/posts/create")
    @ResponseBody
    public String newPost() {
        return "create a new post";
    }

    @GetMapping("/posts/all")
    public String allPosts(Model vModel) {
        List<Post> posts = new ArrayList<>(Arrays.asList(
                new Post(1, "Post 1", "This is a post for post 1"),
                new Post(2, "Post 2", "This is a post for post 2"),
                new Post(3, "Post 3", "This is a post for post 3")
        ));
        vModel.addAttribute("posts", posts);
        return "posts/index";
    }







}
