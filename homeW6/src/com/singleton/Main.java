package com.singleton;

public class Main {
    public static void main(String[] args) {
        ConfigurationManager config = ConfigurationManager.getInstance();
        System.out.println("URL: " + config.getSetting("url"));


        config.setSetting("url", "https://habr.com/ru/articles/129494/");
        config.saveSettingsToFile("config.txt");
    }
}
