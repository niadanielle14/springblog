package com.example.codeup.springblog.controller;

import com.example.codeup.springblog.model.Post;
import com.example.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//private final EmailService emailService;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {

        this.postDao = postDao;
    }
//    @GetMapping("/posts")
//    @ResponseBody
//    public String posts() {
//        return "posts index page";
//    }

    @GetMapping("/posts/{id}")
    public String postsId(@PathVariable long id, Model vModel) {
        Post post = postDao.getReferenceById(id);
        vModel.addAttribute("post", post);
        return "posts/show";
    }
    @GetMapping("/posts/create")
    public String postsCreate() {
        return "posts/create";
    }
    @PostMapping("/posts/create")
    public String savePost(@RequestParam String title, @RequestParam String body) {
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        // save the post to the database with JPA
        postDao.save(post);
        return "redirect:/posts/all";
    }
    @GetMapping("/posts/all")
    public String allPosts(Model vModel) {
        List<Post> posts = postDao.findAll();
        vModel.addAttribute("posts", posts);
        return "posts/index";
    }
}
