package com.example.boot.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HomeController {
    @GetMapping(value = { "home", "/{hi}" }) // tương đương @GetMapping({"home","/"})
    public String getMethodName(@RequestParam(required = false) String param, @PathVariable(required = false) String hi) {
        return "hello" + hi + param;
    }

}
