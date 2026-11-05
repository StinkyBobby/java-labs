package org.example;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        String fileName = "volumes.txt";
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); // чтобы дробная часть вводилась через точку

        try (PrintWriter writer = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"))) {
            System.out.println("Введите 15 вещественных значений объёма жидкости:");
            for (int i = 1; i <= 15; i++) {
                System.out.print("Значение " + i + ": ");
                double volume = scanner.nextDouble();
                writer.println(volume);
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи: " + e.getMessage());
            return;
        }

        double sum = 0;
        int count = 0;
        System.out.println("\n=== Значения из файла ===");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                double volume = Double.parseDouble(line);
                System.out.println(volume);
                sum += volume;
                count++;
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения: " + e.getMessage());
            return;
        }

        if (count > 0) {
            double average = sum / count;
            System.out.printf("%nСредний объём: %.4f%n", average);
        } else {
            System.out.println("Нет данных для вычисления среднего.");
        }
    }
}