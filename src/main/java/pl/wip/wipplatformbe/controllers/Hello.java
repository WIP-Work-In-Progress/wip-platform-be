package pl.wip.wipplatformbe.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping("")
    String hello() {
        return "Hello";
    }
}
