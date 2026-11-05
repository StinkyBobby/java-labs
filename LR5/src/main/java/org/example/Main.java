package org.example;

class Dog {
    public String name;
    public String breed;
    public int age;

    public Dog(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public void bark() {
        System.out.println("Гав!");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Барсик", "Лабрадор", 3);
        System.out.println("Собака: " + dog.name + ", порода: " + dog.breed + ", возраст: " + dog.age);
        dog.bark();
    }
}
