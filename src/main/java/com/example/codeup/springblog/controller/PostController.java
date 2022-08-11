package com.example.codeup.springblog.controller;

import com.example.codeup.springblog.model.Post;

import com.example.codeup.springblog.model.User;
import com.example.codeup.springblog.repositories.PostRepository;
import com.example.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class PostController {
 // JPA CODE
    private final PostRepository postDao;
    private final UserRepository userDao;
    public PostController(PostRepository postDao, UserRepository userDao) {

        this.postDao = postDao;
        this.userDao = userDao;
    }
    @GetMapping( "/posts")
    @ResponseBody
    public String posts() {
        return "posts index page";
    }

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

    // JPA CODE
    @PostMapping("/posts/create")
    public String savePost(@RequestParam String title, @RequestParam String body) {
        User user = userDao.getReferenceById(1L);
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        // saves the user and post to the database with JPA
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts/all";
    }
    @GetMapping("/posts/all")
    public String allPosts(Model vModel) {
        List<Post> posts = postDao.findAll();
        vModel.addAttribute("posts", posts);
        return "posts/index";
    }
    //private final EmailService emailService;

}
