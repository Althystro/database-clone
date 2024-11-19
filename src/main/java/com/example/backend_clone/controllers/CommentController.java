package com.example.backend_clone.controllers;

import com.example.backend_clone.models.Comments;
import com.example.backend_clone.models.Posts;
import com.example.backend_clone.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    public PostRepo postRepo;

    @PostMapping("/posts/{id}/comments")
    public String createComment(@PathVariable String id, @RequestBody Comments comment) {
        for (Posts post : postRepo.posts) {

            if (post.getId().equals(id)) {
                post.getComments().add(comment);
                return "added comments";
            }
        }

        return null;
    }


    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public String deleteComment(@PathVariable String postId, @PathVariable String commentId) {
        for (Posts post : postRepo.posts) {
            if (post.getId().equals(postId)) {
                List<Comments> postComments = post.getComments();
                for (Comments comment : postComments) {
                    if (comment.getId().equals(commentId)) {
                        postComments.remove(comment);
                        return "comment deleted";
                    }
                }
            }
        }
        return null;
    }

}
