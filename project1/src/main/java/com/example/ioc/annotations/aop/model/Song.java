package com.example.ioc.annotations.aop.model;

import org.springframework.stereotype.Component;

import com.example.ioc.annotations.aop.interfaces.logAspect;

@Component
public class Song {

    private String title = "hi";
    private String singerName;
    
    @logAspect
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }
}