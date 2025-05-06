package com.example.ioc.annotations.aop.main;
import com.example.ioc.annotations.aop.config.*;
import com.example.ioc.annotations.aop.model.Song;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Song song = context.getBean(Song.class);
        
        System.out.println("hello" +song.getTitle());
    }
}
