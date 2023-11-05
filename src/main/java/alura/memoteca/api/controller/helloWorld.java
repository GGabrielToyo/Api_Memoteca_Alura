package alura.memoteca.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class helloWorld {

    @GetMapping
    public  String HelloWorld () {
        return "Hello World, testando dev alura Memoteca!";
    }
}