package com.example.day4.web;

import com.example.day4.service.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/latest")
public class TestController {

    private final TestService testService;

    // Error[testService] : Could not autowire. No beans of 'TestService' type found.
    // 해결 : TestServiceImpl에 @Service annotation 추가
    public TestController(TestService testService) {
        this.testService = testService;
    }


    /*
    * postman이라는 프로그램으로 프로젝트를 실행하고
    * 기능이 잘 동작하는지 테스트해본다.
    **/

    // Create

    /**
     * {
     *     "id": 1,
     *     "name": "Rick",
     *     "grade": "A"
     * }
     * */
    @PostMapping("/test")
    // http://localhost:8080/api/latest/test
    public ResponseEntity<String> create(@RequestBody Map<String, String> map) {
        // val1
        // val2
        // intellij 단축키 soutv
        System.out.println("map.id = " + map.get("id"));
        System.out.println("map.name = " + map.get("name"));
        System.out.println("map.grade = " + map.get("grade"));

        testService.joinTest(map);

        return ResponseEntity.ok("CREATED");
    }

    // Read - 단건 조회
    @GetMapping("/test/{id}")
    // http://localhost:8080/api/latest/test1
    // http://localhost:8080/api/latest/test2
    // http://localhost:8080/api/latest/test3
    public ResponseEntity<String> read(@PathVariable Long id) {
        System.out.println("id = " + id);

        testService.findTestById(id);
        System.out.println(testService.findTestById(id));

        return ResponseEntity.ok("READ");
    }

    // Update

    /**
     * {
     *     "name": "Carl",
     *     "grade": "B"
     * }
     * */
    @PutMapping("/test/{id}")
    // http://localhost:8080/api/latest/test1
    // http://localhost:8080/api/latest/test2
    // http://localhost:8080/api/latest/test3
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Map<String, String> map) {
        System.out.println("id = " + id);
        System.out.println("name = " + map.get("name"));
        System.out.println("grade = " + map.get("grade"));

//        Map<String, String> updatedMap = new Map<String, String>() {
//
//        };
//        updatedMap.put("id", Long.toString(id));
//        updatedMap.put("name", map.get("name"));
//        updatedMap.put("name", map.get("name"));

        map.put("id", Long.toString(id));

        testService.updateTest(map);

        return ResponseEntity.ok("UDPATED");
    }

    // Delete
    @DeleteMapping("/test/{id}")
    // http://localhost:8080/api/latest/test1
    // http://localhost:8080/api/latest/test2
    // http://localhost:8080/api/latest/test3
    public ResponseEntity<String> delete(@PathVariable Long id) {
        System.out.println("id = " + id);

        testService.deleteTest(id);

        return ResponseEntity.ok("DELETED");
    }
}
