package com.example.day4.domain.test;

import java.util.Map;

public interface TestRepository {
    // C
    Long save(Map<String, String> map);

    // R
    Map<String, String> findById(Long id);

    // U
    Long update(Map<String, String> map);

    // D
    Long delete(Long id);
}
