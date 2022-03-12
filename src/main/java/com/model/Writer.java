package com.model;

import java.util.List;

public class Writer {
    private Long id;
    public String firstName;
    private String lastName;
    private List<Post> posts;

    public Writer (Long id, String firstName, String lastName, List<Post> posts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.posts = posts;
    }

    public Writer () {
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public List<Post> getPosts () {
        return posts;
    }

    public void setPosts (List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals (Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Writer) && ((Writer) obj).getId() == this.getId()) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode () {
        int r = 17;
        if (id != null)
            return  r * 31 + id.hashCode();
        return r;
    }

}
