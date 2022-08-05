package com.example.codeup.springblog.controller;

import com.example.codeup.springblog.model.Post;
<<<<<<< HEAD
=======
import com.example.codeup.springblog.model.User;
import com.example.codeup.springblog.repositories.PostRepository;
import com.example.codeup.springblog.repositories.UserRepository;
>>>>>>> jpa
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
<<<<<<< HEAD

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
=======


//private final EmailService emailService;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    public PostController(PostRepository postDao, UserRepository userDao) {

        this.postDao = postDao;
        this.userDao = userDao;
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
>>>>>>> jpa
    public String postsCreate() {
        return "posts/create";
    }
    @PostMapping("/posts/create")
<<<<<<< HEAD
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







=======
    public String savePost(@RequestParam String title, @RequestParam String body) {
        User user = userDao.getReferenceById(1L);
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        post.setUser(user);
        // saves the user and post to the database with JPA
        postDao.save(post);
        return "redirect:/posts/all";
    }
    @GetMapping("/posts/all")
    public String allPosts(Model vModel) {
        List<Post> posts = postDao.findAll();
        vModel.addAttribute("posts", posts);
        return "posts/index";
    }
>>>>>>> jpa
}
