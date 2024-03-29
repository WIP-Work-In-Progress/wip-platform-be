package pl.wip.wipplatformbe.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wip.wipplatformbe.models.Test;
import pl.wip.wipplatformbe.requests.TestRequest;
import pl.wip.wipplatformbe.services.TestService;

import java.util.List;

@RestController
public class HelloController {

    private final TestService testService;

    public HelloController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("")
    String hello() {
        return "Hello";
    }

    @GetMapping("/test")
    List<Test> getTests() {
        return testService.getTest();
    }

    @PostMapping("/test")
    void saveTest(TestRequest test) {
        testService.saveTest(test);
    }
}
