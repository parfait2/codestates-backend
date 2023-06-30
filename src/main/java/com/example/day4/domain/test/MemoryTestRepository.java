package com.example.day4.domain.test;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryTestRepository implements TestRepository {

    private final List<Map<String, String>> collectors = new ArrayList<>();

    // Create
    @Override
    public Long save(Map<String, String> map) {
        collectors.add(map);
        // val1 - 1
        // val1 - name

        return Long.parseLong(map.get("id"));

        // 에러가 나는 원인은 map은 String으로 선언되어 있는데,
        // 리턴 타입은 Long이므로 리턴 타입과 타입이 맞지 않아서 에러가 난다.
        // String val1 "1" 값을 Long으로 변환하여 넘겨준다.
    }

    // Read
    @Override
    public Map<String, String> findById(Long id) {
        // 1 - id ---> list index 0
        // 2 - id ---> list index 1
        // 3 - id
        // Long id - 1

//        return collectors.get(id.intValue() - 1);
        return collectors.get(id.intValue() - 1);

    }

    @Override
    public Long update(Map<String, String> map) {
        System.out.println("id" + map.get("id"));
        collectors.remove(Integer.parseInt(map.get("id"))-1);
        collectors.add(map);

        return Long.parseLong(map.get("id"));
    }

    @Override
    public Long delete(Long id) {
        Map<String, String> map = findById(id);
        collectors.remove(map);

        return Long.parseLong(map.get("id"));
    }

    // Update

    // Delete
}
