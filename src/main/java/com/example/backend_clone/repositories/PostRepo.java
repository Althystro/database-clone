package com.example.backend_clone.repositories;

import com.example.backend_clone.models.Posts;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class PostRepo {
    public List<Posts> posts = new ArrayList<>();


}
