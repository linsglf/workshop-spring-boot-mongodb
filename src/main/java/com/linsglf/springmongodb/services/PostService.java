package com.linsglf.springmongodb.services;

import com.linsglf.springmongodb.domain.Post;
import com.linsglf.springmongodb.repository.PostRepository;
import com.linsglf.springmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
}
