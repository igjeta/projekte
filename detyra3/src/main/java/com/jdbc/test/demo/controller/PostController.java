package com.jdbc.test.demo.controller;

import com.jdbc.test.demo.entity.Post;
import com.jdbc.test.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getPosts());
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable(name = "postId") Integer id) {
        return ResponseEntity.ok(postService.getPostsById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getPostsByUserId(@PathVariable(name = "userId") Integer userId) {
        return ResponseEntity.ok(postService.getPostsByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Boolean> addPost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.createPost(post));
    }

    @PutMapping("/user/{postId}")
    public ResponseEntity<Boolean> updatePost(@PathVariable(name = "postId") Integer id, @RequestBody Post post){
        return ResponseEntity.ok(postService.updatePost(id,post));
    }
}
