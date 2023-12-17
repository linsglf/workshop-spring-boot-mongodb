package com.linsglf.springmongodb.repository;

import com.linsglf.springmongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
