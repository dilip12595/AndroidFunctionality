package com.example.androidfunctionality.mains;

public class MainsData {

    private String title;
    private MainsType type;

    public MainsData(String title, MainsType type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public MainsType getType() {
        return type;
    }
}
