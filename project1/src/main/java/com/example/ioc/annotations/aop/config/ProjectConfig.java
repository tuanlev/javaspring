package com.example.ioc.annotations.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan(basePackages = {
    "com.example.ioc.annotations.aop.model",
    "com.example.ioc.annotations.aop.aspects"
})
@EnableAspectJAutoProxy
public class ProjectConfig {
}