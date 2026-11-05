package org.example;

class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double circumference() {
        return 2 * Math.PI * radius;
    }
}

public class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle(5);
        Circle c2 = new Circle(10);
        Circle c3 = new Circle(2.5);

        c1.setRadius(7);

        Circle[] circles = {c1, c2, c3};

        for (Circle c : circles) {
            System.out.println("Радиус: " + c.getRadius());
            System.out.println("Площадь: " + String.format("%.2f", c.area()));
            System.out.println("Длина окружности: " + String.format("%.2f", c.circumference()));
            System.out.println();
        }
    }
}
