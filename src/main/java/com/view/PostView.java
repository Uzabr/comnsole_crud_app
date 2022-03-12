package com.view;

import com.model.Post;
import com.repository.JsonPostRepositoryImpl;
import com.repository.PostRepository;

import java.util.List;

public class PostView {

    public static  PostRepository postRepo;

    public PostView() {
        postRepo = new JsonPostRepositoryImpl();
    }

    public static void viewPosts() {
        List<Post> list = postRepo.getAll();
    System.out.println(list);
    }

    public static void createPost(Post post) {
        postRepo.create(post);
    }

    public static void updatePost(Post post, long id) {
        postRepo.update(post, id);
    }

    public static void deletePost(Post post, long id) {
        postRepo.delete(post, id);
    }

}
