package pl.wip.wipplatformbe.services;

import org.springframework.stereotype.Service;
import pl.wip.wipplatformbe.models.Test;
import pl.wip.wipplatformbe.repositories.TestRepository;
import pl.wip.wipplatformbe.dto.requests.TestRequest;

import java.util.List;

@Service
public class TestService {

    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }
    public List<Test> getTest() {
        return testRepository.findAll();
    }

    public void saveTest(TestRequest testRequest) {
        Test test = new Test();
        test.setName(testRequest.name());
        testRepository.save(test);
    }

    public void deleteTest(String id) {
        testRepository.deleteById(id);
    }

    public void updateTest(String id, TestRequest testRequest) {
        Test test = testRepository.findById(id).orElseThrow();
        test.setName(testRequest.name());
        testRepository.save(test);
    }

}


