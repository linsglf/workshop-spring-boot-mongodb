package com.linsglf.springmongodb.repository;

import com.linsglf.springmongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'author.id' : ?0 }")
    public List<Post> findByAuthorId(String id);

    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{ 'title' : { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);
}
