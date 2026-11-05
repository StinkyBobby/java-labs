package packageLists;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Map<String, Garment> garmentMap = new HashMap<>();

        garmentMap.put("Кожаная куртка", new Jacket("Кожаная куртка", "J001", "L", "Кожа"));
        garmentMap.put("Зимний пуховик", new Jacket("Зимний пуховик", "J002", "XL", "Нейлон"));
        garmentMap.put("Джинсовка", new Jacket("Джинсовка", "J003", "M", "Деним"));

        garmentMap.put("Футболка Basic", new TShirt("Футболка Basic", "T001", "M", "Однотонная"));
        garmentMap.put("Футболка Rock", new TShirt("Футболка Rock", "T002", "L", "Принт с черепом"));
        garmentMap.put("Футболка Summer", new TShirt("Футболка Summer", "T003", "S", "Пальмы"));

        garmentMap.put("Джинсы Slim", new Pants("Джинсы Slim", "P001", "32", 102.5));
        garmentMap.put("Спортивные штаны", new Pants("Спортивные штаны", "P002", "L", 100.0));

        System.out.println("Коллекция");
        garmentMap.forEach((key, value) -> {
            System.out.println("Ключ: " + key + ", Объект: " + value);
        });






        List<Programmer> programmers = new ArrayList<>();
        programmers.add(new Programmer(1, "Алексей Иванов", "Java", 3, List.of(5, 4, 5, 5, 4)));
        programmers.add(new Programmer(2, "Мария Петрова", "Python", 2, List.of(4, 3, 5, 4)));
        programmers.add(new Programmer(3, "Иван Сидоров", "JavaScript", 1, List.of(3, 2, 4)));
        programmers.add(new Programmer(6, "ван Сидоров", "JavaScript", 1, List.of(2, 2, 2)));
        programmers.add(new Programmer(4, "Ольга Смирнова", "C++", 3, List.of(2,2)));
        programmers.add(new Programmer(5, "Дмитрий Козлов", "Go", 2, List.of(5, 5, 4, 5)));
        programmers.add(new Programmer(5, "митрий Козлов", "Go", 2, List.of(5, 5, 4, 5)));

        System.out.println("Начальный список программистов");
        for (Programmer el : programmers) {
            System.out.println(el);
        }

        /*
        for(Programmer el : programmers) {
            if (el.averageRating() < 3) {
                programmers.remove(el);
            } else if(el.averageRating() >= 4) {
                el.setLevel(el.getLevel() + 1);
                System.out.println("Уровень программиста повышен");
            }
        }
        */

        Iterator<Programmer> iterate = programmers.iterator();
        while(iterate.hasNext()) {
            Programmer el = iterate.next();
            if (el.averageRating() < 3) {
                iterate.remove();
            } else if (el.averageRating() >= 4) {
                el.setLevel(el.getLevel() + 1);
                System.out.println("Уровень программиста повышен");
            }
        }


        Programmer.printProgrammers(programmers, 2);
        Programmer.sortAndPrint(programmers);
    }
}
