package com.krishnamg.app.dtos;

/**
 * Created by krishnamg on 4/8/17.
 */
public class Topic {

    private String id;
    private String name;

    public Topic(){

    }

    public Topic(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}