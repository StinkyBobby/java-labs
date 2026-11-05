package org.example;

class Actor {
    protected String name;
    protected int age;
    protected String genre;

    public Actor(String name, int age, String genre) {
        this.name = name;
        this.age = age;
        this.genre = genre;
    }

    public void perform() {
        System.out.println("Выступает");
    }

    public void perform(String role) {
        System.out.println("Играет роль " + role);
    }

    public void perform(int scenes) {
        System.out.println("Играет в " + scenes + " сценах");
    }

    public String getAwards() {
        return "Нет наград";
    }
}

class Singer extends Actor {
    public Singer(String name, int age, String genre) {
        super(name, age, genre);
    }

    @Override
    public String getAwards() {
        return "5 наград";
    }
}

class Dancer extends Actor {
    public Dancer(String name, int age, String genre) {
        super(name, age, genre);
    }

    @Override
    public String getAwards() {
        return "3 награды";
    }
}

public class Main {
    public static void main(String[] args) {
        Singer singer = new Singer("Иван", 30, "Поп");
        Dancer dancer = new Dancer("Анна", 25, "Балет");

        System.out.println("Певец: " + singer.name + ", возраст: " + singer.age + ", жанр: " + singer.genre);
        singer.perform();
        singer.perform("Главную");
        singer.perform(10);
        System.out.println("Награды: " + singer.getAwards());

        System.out.println();

        System.out.println("Танцор: " + dancer.name + ", возраст: " + dancer.age + ", жанр: " + dancer.genre);
        dancer.perform();
        dancer.perform("Второстепенную");
        dancer.perform(5);
        System.out.println("Награды: " + dancer.getAwards());
    }
}