package org.example;

class CelestialBody {
    protected String name;
    protected double mass;
    protected double diameter;

    public CelestialBody(String name, double mass, double diameter) {
        this.name = name;
        this.mass = mass;
        this.diameter = diameter;
    }

    public String getType() {
        return "Небесное тело";
    }

    public void displayInfo() {
        System.out.println(name + ", масса: " + mass + ", диаметр: " + diameter);
    }
}

class Planet extends CelestialBody {
    private int moons;

    public Planet(String name, double mass, double diameter, int moons) {
        super(name, mass, diameter);
        this.moons = moons;
    }

    @Override
    public String getType() {
        return "Планета";
    }

    public double getGravity() {
        return mass / (diameter * diameter);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Спутников: " + moons);
        System.out.println("Сила притяжения: " + String.format("%.4f", getGravity()));
    }
}

class Star extends CelestialBody {
    private double temperature;

    public Star(String name, double mass, double diameter, double temperature) {
        super(name, mass, diameter);
        this.temperature = temperature;
    }

    @Override
    public String getType() {
        return "Звезда";
    }

    public double getLuminosity() {
        return Math.pow(diameter, 2) * Math.pow(temperature, 4);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Температура: " + temperature);
        System.out.println("Светимость: " + String.format("%.2e", getLuminosity()));
    }
}

public class Main {
    public static void main(String[] args) {
        Planet earth = new Planet("Земля", 5.97e24, 12742, 1);
        Planet mars = new Planet("Марс", 6.42e23, 6779, 2);
        Star sun = new Star("Солнце", 1.989e30, 1392700, 5778);
        Star sirius = new Star("Сириус", 4.02e30, 2380000, 9940);

        CelestialBody[] bodies = {earth, mars, sun, sirius};

        for (CelestialBody body : bodies) {
            System.out.println("Тип: " + body.getType());
            body.displayInfo();
            if (body instanceof Planet) {
                Planet p = (Planet) body;
                System.out.println("Гравитация: " + String.format("%.4f", p.getGravity()));
            } else if (body instanceof Star) {
                Star s = (Star) body;
                System.out.println("Светимость: " + String.format("%.2e", s.getLuminosity()));
            }
            System.out.println();
        }
    }
}