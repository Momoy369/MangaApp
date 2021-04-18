package com.lomboktech.mangaapp.model;

import java.io.Serializable;

public class ModelGenre implements Serializable {

    private String title;
    private String endpoint;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}