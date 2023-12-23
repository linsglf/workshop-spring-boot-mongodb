package com.linsglf.springmongodb.services;

import com.linsglf.springmongodb.domain.Post;
import com.linsglf.springmongodb.dto.AuthorDTO;
import com.linsglf.springmongodb.repository.PostRepository;
import com.linsglf.springmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    @Autowired
    private UserService userService;

    public Post findById(String id) {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public void updateAuthor(String id) {
        List<Post> posts = userService.findById(id).getPosts();
        List<Post> updatedPosts = new ArrayList<>();
        posts.forEach(post -> {
            post.setAuthor(new AuthorDTO(userService.findById(id)));
            updatedPosts.add(post);
        });
        repo.saveAll(updatedPosts);
    }

    public void deleteUserPosts(String id) {
        List<Post> posts = userService.findById(id).getPosts();
        repo.deleteAll(posts);
    }

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }
}
