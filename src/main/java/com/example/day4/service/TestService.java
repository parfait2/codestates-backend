package com.example.day4.service;

import java.util.Map;

public interface TestService {
    // 테스트 생성 - C
    Long joinTest(Map<String, String> map);

    // 테스트 단건 조회 - R
    Map<String, String> findTestById(Long id);

    // 테스트 수정 - U
    Long updateTest(Map<String, String> map);

    // 테스트 삭제 - D
    Long deleteTest(Long id);

}
