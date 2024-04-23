package pl.wip.wipplatformbe.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pl.wip.wipplatformbe.models.Test;
import pl.wip.wipplatformbe.dto.requests.TestRequest;
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
    
    @GetMapping("/test/auth/required")
    public ResponseEntity<String> testAuthRequired() {
        return ResponseEntity.ok("User logged in");
    }

    @GetMapping("/test/auth/optional")
    public ResponseEntity<String> testAuthOptional(Authentication authentication) {
        if (authentication == null)
            return ResponseEntity.ok("User not logged in, but path is not protected");
        
        String responseMessage = "User logged in, username: " + authentication.getName();
        return ResponseEntity.ok(responseMessage);
    }
    
    @GetMapping("/test/auth/admin")
    public ResponseEntity<String> testAdmin() {
        return ResponseEntity.ok("This should not appear, as there is no way to create admins as of yet");
    }
    
    @GetMapping("/test/auth/user")
    public ResponseEntity<String> testUser() {
        return ResponseEntity.ok("This should appear only if user is logged in and has USER role");
    }
}
