package org.example;

class Computer {
    private String brand;
    private String processor;
    private int ram;

    private static int totalComputers = 0;
    private static int totalRAM = 0;

    public Computer(String brand, String processor, int ram) {
        this.brand = brand;
        this.processor = processor;
        this.ram = ram;
        totalComputers++;
        totalRAM += ram;
    }

    public static double getAverageRAM() {
        if (totalComputers == 0) {
            return 0;
        }
        return (double) totalRAM / totalComputers;
    }

    public void displayInfo() {
        System.out.println(brand + ", " + processor + ", RAM: " + ram + " GB");
    }
}

public class Main {
    public static void main(String[] args) {
        Computer c1 = new Computer("Dell", "Intel Core i5", 8);
        Computer c2 = new Computer("HP", "Intel Core i7", 16);
        Computer c3 = new Computer("Lenovo", "AMD Ryzen 5", 12);
        Computer c4 = new Computer("Asus", "AMD Ryzen 7", 32);
        Computer c5 = new Computer("Acer", "Intel Core i3", 4);

        c1.displayInfo();
        c2.displayInfo();
        c3.displayInfo();
        c4.displayInfo();
        c5.displayInfo();

        System.out.println();
        System.out.println("Всего компьютеров: " + Computer.totalComputers);
        System.out.println("Средняя память: " + String.format("%.2f", Computer.getAverageRAM()) + " GB");
    }
}
