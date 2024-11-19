package com.example.backend_clone.controllers;

import com.example.backend_clone.models.Posts;
import com.example.backend_clone.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostsController {

    @Autowired
    public PostRepo postRepo;


    @GetMapping("/posts")
    public List<Posts> getAllPosts() {
        return postRepo.posts;
    }

    @GetMapping("/posts/{id}")
    public Posts getPostById(@PathVariable String id) {
        for (Posts post : postRepo.posts) {

            if (post.getId().equals(id)) {
                return post;
            }
        }

        return null;
    }


    @PostMapping("/posts")
    public String createPost(@RequestBody Posts post) {
        postRepo.posts.add(post);
        return "Post added!";

    }


    @DeleteMapping("/posts/{id}")
    public String deletePost(@PathVariable String id) {

        for (Posts post : postRepo.posts) {

            if (post.getId().equals(id)) {
                postRepo.posts.remove(post);
                return "post deleted";
            }

        }

        return null;

    }


}
