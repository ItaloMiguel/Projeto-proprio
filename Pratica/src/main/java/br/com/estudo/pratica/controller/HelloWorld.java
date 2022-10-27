package br.com.estudo.pratica.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloWorld {

    @GetMapping
    public String helloWorld() {
        return "Hello, World!";
    }

    @PostMapping("/{name}")
    public String helloUser(@PathVariable String name) {
        return "Hello, " + name;
    }
}
