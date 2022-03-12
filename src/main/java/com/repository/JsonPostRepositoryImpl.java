package com.repository;

import com.google.gson.Gson;
import com.model.Post;
import org.w3c.dom.ls.LSInput;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class JsonPostRepositoryImpl implements PostRepository {
    private final Gson gson = new Gson();
    @Override
    public void create (Post post) {
            try {
                List<Post> postList = new ArrayList<>();
                postList.add(post);
                gson.toJson(postList, new FileWriter("post.json"));
            }
            catch (Exception e) {
                e.printStackTrace();
            }
    }

    @Override
    public void update (Post post, Long aLong) {
        Post[] posts = gson.fromJson("post.json", Post[].class);
        List<Post> postList = Arrays.asList(posts);
        Optional<Post> optional = postList
                .stream()
                .filter(x -> Objects.equals(x.getId(), aLong ))
                .findFirst();
        if (optional.isEmpty()) {
      System.out.println("Post не обнаружен ");
        }
        else {
            postList.remove(optional.get());
            postList.add(post);
            try {
            gson.toJson(postList, new FileWriter("post.json"));
            }
            catch (Exception e)  {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Post> getAll () {
        Post[] posts = null;
        try {
         posts = gson.fromJson(new FileReader("post.json"), Post[].class);
         }
        catch (Exception e) {
            e.printStackTrace();
        }
        assert posts != null;
        return Arrays.asList(posts);
    }

    @Override
    public void delete (Post post, Long aLong) {
        List<Post> posts = getAll();
        Optional<Post> optional = posts
                .stream()
                .filter(x -> Objects.equals(x.getId(), aLong))
                .findFirst();
        if (optional.get().equals(post)) {
            posts.remove(post);
        }
    }
}
