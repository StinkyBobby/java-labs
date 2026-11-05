package org.example;

import java.io.*;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        String fName = "f.txt";
        String gName = "g.txt";
        String hName = "h.txt";

        Random random = new Random();
        try (PrintWriter writer = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(fName), "UTF-8"))) {
            for (int i = 0; i < 20; i++) {
                int num = random.nextInt(2000) - 1000; // от -1000 до 999
                writer.println(num);
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи в f: " + e.getMessage());
            return;
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(fName), "UTF-8"));
             PrintWriter writerG = new PrintWriter(
                     new OutputStreamWriter(new FileOutputStream(gName), "UTF-8"));
             PrintWriter writerH = new PrintWriter(
                     new OutputStreamWriter(new FileOutputStream(hName), "UTF-8"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                int num = Integer.parseInt(line);

                if (String.valueOf(Math.abs(num)).contains("5")) {
                    writerG.println(num);
                } else {
                    writerH.println(num);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка обработки: " + e.getMessage());
            return;
        }

        System.out.println("Исходный файл 'f':");
        printFile(fName);
        System.out.println("\nФайл 'g' (содержат цифру 5):");
        printFile(gName);
        System.out.println("\nФайл 'h' (остальные):");
        printFile(hName);
    }

    private static void printFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения " + fileName + ": " + e.getMessage());
        }
    }
}