package pl.wip.wipplatformbe.controllers;

import org.springframework.web.bind.annotation.*;
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
    void saveTest(@RequestBody TestRequest test) {
        testService.saveTest(test);
    }

    @DeleteMapping("/test/{id}")
    void deleteTest(@PathVariable String id) {
        testService.deleteTest(id);
    }

    @PatchMapping("/test/{id}")
    void updateTest(@PathVariable String id, TestRequest test) {
        testService.updateTest(id, test);
    }
}
