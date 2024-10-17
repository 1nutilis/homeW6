package com.singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.io.*;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private static Lock lock = new ReentrantLock();
    private Map<String, String> settings;

    private ConfigurationManager() {
        settings = new HashMap<>();
        loadSettingsFromFile("config.txt");
    }

    // Метод для получения единственного экземпляра
    public static ConfigurationManager getInstance() {
        if (instance == null) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    private void loadSettingsFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    settings.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла настроек: " + e.getMessage());
        }
    }


    public String getSetting(String key) {
        return settings.get(key);
    }


    public void setSetting(String key, String value) {
        settings.put(key, value);
    }


    public void saveSettingsToFile(String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : settings.entrySet()) {
                writer.println(entry.getKey() + "=" + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл настроек: " + e.getMessage());
        }
    }
}