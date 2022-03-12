package com.repository;

import com.model.Post;

import java.util.List;

public interface PostRepository extends GenericRepository<Post, Long>{

    @Override
    void create (Post post);

    @Override
    void update (Post post, Long aLong);

    @Override
    List<Post> getAll ();

    @Override
    void delete (Post post, Long aLong);
}
