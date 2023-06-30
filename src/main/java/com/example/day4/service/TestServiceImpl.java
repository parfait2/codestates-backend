package com.example.day4.service;

import com.example.day4.domain.test.MemoryTestRepository;
import com.example.day4.domain.test.TestRepository;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {
    //    private final TestRepository testRepository;
    // Error : Variable 'testRepository' might not have been initialized

    //    private final TestRepository testRepository = new MemoryTestRepository(); -> 객체지향스럽지 않음.

    private final TestRepository testRepository;

//    public TestServiceImpl(MemoryTestRepository memoryTestRepository) {
//        this.testRepository = memoryTestRepository; // 구현체에 의존하고 있기 때문에 객체지향적이지 않다.
//    }

    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

//    Spring Application Context가 의존성 주입 해줌. 자동으로 Bean으로 관리될 수 있도록 해줌. @Component annotation


    // Create
    @Override
    public Long joinTest(Map<String, String> map) {
        return testRepository.save(map);
    }

    // Read
    @Override
    public Map<String, String> findTestById(Long id) {
        return testRepository.findById(id);
    }

    @Override
    public Long updateTest(Map<String, String> map) {
        return testRepository.update(map);
    }

    @Override
    public Long deleteTest(Long id) {
        return testRepository.delete(id);
    }
}
