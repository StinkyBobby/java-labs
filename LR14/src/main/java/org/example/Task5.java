package org.example;

import java.io.*;
import java.util.Random;

public class Task5 {
    public static void main(String[] args) {
        String fileName = "f.txt";
        Random random = new Random();

        try (PrintWriter writer = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"))) {
            for (int i = 0; i < 10; i++) {
                int num = random.nextInt(201) - 100; // от -100 до 100
                writer.println(num);
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи: " + e.getMessage());
            return;
        }

        int countInRange = 0;
        System.out.println("=== Числа из файла ===");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                int num = Integer.parseInt(line);
                System.out.println(num);
                if (num >= -50 && num <= 50) {
                    countInRange++;
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения: " + e.getMessage());
            return;
        }

        System.out.println("\nКоличество чисел в диапазоне [-50; 50]: " + countInRange);
    }
}