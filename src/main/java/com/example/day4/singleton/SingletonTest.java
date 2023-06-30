package com.example.day4.singleton;

public class SingletonTest {

    public void test() {
//        Settings settings = new Settings();
        Settings settings1 = Settings.getSettings(); // singleton
        Settings settings2 = Settings.getSettings();
        // -> Settings 객체를 하나만 돌려서 쓴다.
    }
}
