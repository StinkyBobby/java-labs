package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Employee {
    private String fullname;
    private double salary;

    public Employee(String fullname, double salary) {
        this.fullname = fullname;
        this.salary = salary;
    }

    public String getFullname() { return fullname; }
    public double getSalary() { return salary; }
}

class Report {
    public static void generateReport(Employee[] employees) {
        System.out.printf("%-15s | %10s%n", "Фамилия", "Зарплата");
        System.out.println("----------------+-----------");
        for (Employee e : employees) {
            System.out.printf("%-15s | %10.2f%n", e.getFullname(), e.getSalary());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("========== ЗАДАНИЕ 1 ==========");
        task1();
        System.out.println("\n========== ЗАДАНИЕ 2 ==========");
        task2();
        System.out.println("\n========== ЗАДАНИЕ 3 ==========");
        task3();
        System.out.println("\n========== ЗАДАНИЕ 4 (пункт 14) ==========");
        task4();
    }

    static void task1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String s = sc.nextLine();

        System.out.println("1. Длина: " + s.length());
        System.out.println("2. Первый символ: " + (s.isEmpty() ? "нет" : s.charAt(0)));
        System.out.println("3. Последний символ: " + (s.isEmpty() ? "нет" : s.charAt(s.length() - 1)));
        System.out.println("4. Верхний регистр: " + s.toUpperCase());
        System.out.println("5. Нижний регистр: " + s.toLowerCase());
        System.out.println("6. Пустая: " + s.isEmpty());
        System.out.println("7. Только пробелы: " + s.isBlank());

        System.out.print("Введите вторую строку для сравнения: ");
        String s2 = sc.nextLine();
        System.out.println("8. equals: " + s.equals(s2));
        System.out.println("9. equalsIgnoreCase: " + s.equalsIgnoreCase(s2));

        System.out.println("10. indexOf('а'): " + s.indexOf('а'));
        System.out.println("11. lastIndexOf('о'): " + s.lastIndexOf('о'));
        System.out.println("12. startsWith(\"Привет\"): " + s.startsWith("Привет"));
        System.out.println("13. endsWith(\".txt\"): " + s.endsWith(".txt"));
        System.out.println("14. replace 'е'->'и': " + s.replace('е', 'и'));
        System.out.println("15. replace ' '->'_': " + s.replace(' ', '_'));
        System.out.println("16. trim: [" + s.trim() + "]");
        System.out.println("17. Конкатенация: " + s + " " + s2);

        if (s.length() >= 8) System.out.println("18. substring(3,7): " + s.substring(3, 7));
        else System.out.println("18. substring(3,7): недостаточно символов");

        if (s.length() >= 5) {
            System.out.println("19. substring(0,4): " + s.substring(0, 4));
            System.out.println("20. substring(5): " + s.substring(5));
            System.out.println("21. charAt(4): " + s.charAt(4));
        } else System.out.println("19-21: недостаточно символов");

        char[] chars = s.toCharArray();
        System.out.print("22. toCharArray: ");
        for (char c : chars) System.out.print(c + " ");
        System.out.println();

        System.out.println("23. contains(\"Java\"): " + s.contains("Java"));
        int num = 123;
        String numStr = String.valueOf(num);
        System.out.println("24. String.valueOf(123): " + numStr);
        try {
            int parsed = Integer.parseInt(numStr);
            System.out.println("25. parseInt * 2: " + (parsed * 2));
        } catch (NumberFormatException e) {
            System.out.println("25. Не число");
        }

        System.out.println("26. Символы в столбик:");
        for (int i = 0; i < s.length(); i++) System.out.println(s.charAt(i));

        int countO = 0;
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) == 'о') countO++;
        System.out.println("27. Количество 'о': " + countO);

        int upper = 0;
        for (int i = 0; i < s.length(); i++) if (Character.isUpperCase(s.charAt(i))) upper++;
        System.out.println("28. Заглавных букв: " + upper);

        String rev = new StringBuilder(s).reverse().toString();
        System.out.println("29. Зеркальные (s и reverse(s)): " + s.equals(rev));

        System.out.println("30. Строка " + s.length() + " раз:");
        for (int i = 0; i < s.length(); i++) System.out.println(s);
    }

    static void task2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите предложение: ");
        String text = sc.nextLine();

        String[] words = text.split("\\s+");

        System.out.println("1. Слова с новой строки:");
        for (String w : words) System.out.println(w);
        System.out.println("2. Количество слов: " + words.length);

        String shortest = words[0], longest = words[0];
        for (String w : words) {
            if (w.length() < shortest.length()) shortest = w;
            if (w.length() > longest.length()) longest = w;
        }
        System.out.println("3. Самое короткое: " + shortest);
        System.out.println("4. Самое длинное: " + longest);

        StringBuilder revWords = new StringBuilder();
        for (String w : words) revWords.append(new StringBuilder(w).reverse()).append(" ");
        System.out.println("5. Перевёрнутые слова: " + revWords.toString().trim());

        String clean = text.replaceAll("\\s+", "").toLowerCase();
        String rev = new StringBuilder(clean).reverse().toString();
        System.out.println("6. Палиндром: " + clean.equals(rev));

        String noVowels = text.replaceAll("(?i)[аеёиоуыэюяaeiou]", "");
        System.out.println("7. Без гласных: " + noVowels);

        int vowels = 0, consonants = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            if ("аеёиоуыэюяaeiou".indexOf(c) >= 0) vowels++;
            else if (Character.isLetter(c)) consonants++;
        }
        System.out.println("8. Гласных: " + vowels + ", согласных: " + consonants);

        String email = "user@domain.com";
        int at = email.indexOf('@');
        System.out.println("9. Имя пользователя: " + email.substring(0, at));
        System.out.println("10. Домен: " + email.substring(at + 1));

        boolean validEmail = email.contains("@") && email.indexOf('.', at) > at;
        System.out.println("11. Корректный email: " + validEmail);

        String phone = "+375291234567";
        boolean validPhone = phone.matches("\\+?\\d+");
        System.out.println("12. Корректный телефон: " + validPhone);

        String fio = "Иванов Петр Сидорович";
        String[] parts = fio.split("\\s+");
        System.out.println("13. Инициалы: " + parts[0] + " " + parts[1].charAt(0) + ". " + parts[2].charAt(0) + ".");

        String compressed = text.replaceAll("(.)\\1+", "$1");
        System.out.println("14. Сжатая строка: " + compressed);

        System.out.println("15. Только буквы и цифры: " + text.matches("[\\p{L}\\p{N}]+"));

        System.out.print("16. Позиции 'a': ");
        for (int i = 0; i < text.length(); i++) if (text.charAt(i) == 'a') System.out.print(i + " ");
        System.out.println();

        StringBuilder filtered = new StringBuilder();
        for (String w : words) if (w.length() >= 3) filtered.append(w).append(" ");
        System.out.println("17. Без слов <3 символов: " + filtered.toString().trim());

        System.out.println("18-30. (повторы пунктов 1-13)");
        System.out.println("19. Количество слов: " + words.length);
        System.out.println("20. Самое короткое: " + shortest);
        System.out.println("21. Самое длинное: " + longest);
        System.out.println("22. Перевёрнутые слова: " + revWords.toString().trim());
        System.out.println("23. Палиндром: " + clean.equals(rev));
        System.out.println("24. Без гласных: " + noVowels);
        System.out.println("25. Гласных/согласных: " + vowels + "/" + consonants);
        System.out.println("26. Имя пользователя: " + email.substring(0, at));
        System.out.println("27. Домен: " + email.substring(at + 1));
        System.out.println("28. Корректный email: " + validEmail);
        System.out.println("29. Корректный телефон: " + validPhone);

        String fio2 = "Смирнова Елена Игоревна";
        String[] p2 = fio2.split("\\s+");
        System.out.println("30. Инициалы: " + p2[0] + " " + p2[1].charAt(0) + ". " + p2[2].charAt(0) + ".");
    }

    static void task3() {
        Employee[] employees = {
                new Employee("Иванов", 1500.50),
                new Employee("Петров", 2300.00),
                new Employee("Сидоров", 980.75),
                new Employee("Смирнова", 3100.25)
        };
        Report.generateReport(employees);
    }

    static void task4() {
        String s = "a1a a22a a333a a4444a a55555a";
        Pattern p = Pattern.compile("a[02468]+a");
        Matcher m = p.matcher(s);
        System.out.println("Строки с чётными цифрами между 'a':");
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}