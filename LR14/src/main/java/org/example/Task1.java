package org.example;

import java.io.*;
import java.nio.file.*;

public class Task1 {
    public static void main(String[] args) {
        String fileName = "favorite_food.txt";
        File file = new File(fileName);

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {
            writer.write("Блюдо: Пельмени");
            writer.newLine();
            writer.write("Ингредиенты: мука, мясо, лук, соль, перец");
            writer.newLine();
            writer.write("Время приготовления: 90 минут");
            writer.newLine();
            writer.write("Порций: 4");
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Ошибка записи: " + e.getMessage());
            return;
        }

        System.out.println("=== Данные о файле ===");
        System.out.println("Имя файла:      " + file.getName());
        System.out.println("Размер:         " + file.length() + " байт");
        System.out.println("Последнее изм.: " + file.lastModified());
        System.out.println("Путь:           " + file.getPath());
        System.out.println("Абс. путь:      " + file.getAbsolutePath());
        System.out.println("Существует:     " + file.exists());
        System.out.println("Читаемый:       " + file.canRead());
        System.out.println("Записываемый:   " + file.canWrite());
        System.out.println("Это файл:       " + file.isFile());
        System.out.println("Это каталог:    " + file.isDirectory());

        System.out.println("\n=== Содержимое файла ===");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения: " + e.getMessage());
        }
    }
}
