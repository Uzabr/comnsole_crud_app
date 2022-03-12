package com.model;

import java.util.List;

public class Post {

    private Long id;
    private String content;
    private boolean created = false;
    private boolean updated = false;
    private List<Label> labels;

    public Post (Long id, String content, boolean created, boolean updated, List<Label> labels) {
        this.id = id;
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.labels = labels;
    }

    public Post () {
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
    }

    public boolean isCreated () {
        return created;
    }

    public void setCreated (boolean created) {
        this.created = created;
    }

    public boolean isUpdated () {
        return updated;
    }

    public void setUpdated (boolean updated) {
        this.updated = updated;
    }

    public List<Label> getLables () {
        return labels;
    }

    public void setLables (List<Label> labels) {
        this.labels = labels;
    }
}
