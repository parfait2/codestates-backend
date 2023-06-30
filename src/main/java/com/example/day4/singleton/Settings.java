package com.example.day4.singleton;

// singleton pattern : private으로 접근제한자를 설정함으로써 외부에서 접근할 수 없도록 한다.
public class Settings {
    private static Settings settings = null;

    public static Settings getSettings() {
        if(settings == null) {
            settings = new Settings();
        }

        return settings;
    }

    private int fontSize = 10;

    public int getFontSize() {
        return fontSize;

    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;

    }
}
