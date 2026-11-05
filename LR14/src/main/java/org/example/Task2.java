package org.example;

import java.io.*;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        String fileName = "f.txt";
        Scanner scanner = new Scanner(System.in);

        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"))) {
            System.out.println("Введите 10 целых чисел:");
            for (int i = 1; i <= 10; i++) {
                System.out.print("Число " + i + ": ");
                int num = scanner.nextInt();
                writer.println(num);
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи: " + e.getMessage());
            return;
        }

        int countOdd = 0;
        System.out.println("\n=== Числа из файла ===");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                int num = Integer.parseInt(line);
                System.out.println(num);
                if (num % 2 != 0) {
                    countOdd++;
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения: " + e.getMessage());
            return;
        }

        System.out.println("\nКоличество чисел, не кратных 2: " + countOdd);
    }
}