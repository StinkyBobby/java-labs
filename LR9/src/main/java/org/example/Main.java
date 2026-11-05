package org.example;

abstract class Clothing {
    protected String brand;
    protected int size;
    protected String color;

    public Clothing(String brand, int size, String color) {
        this.brand = brand;
        this.size = size;
        this.color = color;
    }

    public abstract String getSeason();
    public abstract String getMaterial();

    public void displayInfo() {
        System.out.println(brand + ", размер " + size + ", цвет " + color);
    }
}

class Jacket extends Clothing {
    private String material;

    public Jacket(String brand, int size, String color, String material) {
        super(brand, size, color);
        this.material = material;
    }

    @Override
    public String getSeason() {
        return "Осень/Зима";
    }

    @Override
    public String getMaterial() {
        return "Кожа";
    }

    public String getJacketMaterial() {
        return material;
    }
}

class TShirt extends Clothing {
    private String print;

    public TShirt(String brand, int size, String color, String print) {
        super(brand, size, color);
        this.print = print;
    }

    @Override
    public String getSeason() {
        return "Весна/Лето";
    }

    @Override
    public String getMaterial() {
        return "Хлопок";
    }

    public String getPrint() {
        return print;
    }
}

public class Main {
    public static void main(String[] args) {
        Jacket j1 = new Jacket("Zara", 50, "Черный", "Натуральная кожа");
        Jacket j2 = new Jacket("H&M", 48, "Коричневый", "Эко-кожа");
        Jacket j3 = new Jacket("Mango", 52, "Бежевый", "Замша");

        TShirt t1 = new TShirt("Nike", 46, "Белый", "Swoosh");
        TShirt t2 = new TShirt("Adidas", 48, "Синий", "Три полоски");

        Clothing[] items = {j1, j2, j3, t1, t2};

        for (Clothing item : items) {
            item.displayInfo();
            System.out.println("Сезон: " + item.getSeason());
            System.out.println("Материал: " + item.getMaterial());
            System.out.println();
        }
    }
}
