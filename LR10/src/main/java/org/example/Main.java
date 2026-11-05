package org.example;

interface Connectable {
    void connect();
    void disconnect();
    boolean isConnected();
}

interface Configurable {
    void configure();
    void reset();
}

class Router implements Connectable, Configurable {
    private String model;
    private boolean connected;
    private String settings;

    public Router(String model, String settings) {
        this.model = model;
        this.settings = settings;
        this.connected = false;
    }

    @Override
    public void connect() {
        connected = true;
        System.out.println("Роутер " + model + " подключен");
    }

    @Override
    public void disconnect() {
        connected = false;
        System.out.println("Роутер " + model + " отключен");
    }

    @Override
    public boolean isConnected() {
        return connected;
    }

    @Override
    public void configure() {
        System.out.println("Роутер " + model + " настроен: " + settings);
    }

    @Override
    public void reset() {
        settings = "default";
        System.out.println("Роутер " + model + " сброшен");
    }

    public String getModel() { return model; }
}

class Computer implements Connectable {
    private String model;
    private boolean connected;
    private String os;

    public Computer(String model, String os) {
        this.model = model;
        this.os = os;
        this.connected = false;
    }

    @Override
    public void connect() {
        connected = true;
        System.out.println("Компьютер " + model + " (" + os + ") подключен");
    }

    @Override
    public void disconnect() {
        connected = false;
        System.out.println("Компьютер " + model + " отключен");
    }

    @Override
    public boolean isConnected() {
        return connected;
    }

    public String getModel() { return model; }
}

public class Main {
    public static void main(String[] args) {
        Router r1 = new Router("TP-Link AX3000", "WiFi-6");
        Router r2 = new Router("Asus RT-AX88U", "WiFi-6");
        Router r3 = new Router("MikroTik hAP", "RouterOS");

        Computer c1 = new Computer("Dell XPS 15", "Windows 11");
        Computer c2 = new Computer("MacBook Pro", "macOS");

        r1.configure();
        r2.configure();
        r3.reset();
        r3.configure();

        r1.connect();
        r2.connect();
        r3.connect();
        c1.connect();
        c2.connect();

        System.out.println();
        System.out.println("Статус подключения:");
        System.out.println("Роутер " + r1.getModel() + ": " + (r1.isConnected() ? "подключен" : "отключен"));
        System.out.println("Роутер " + r2.getModel() + ": " + (r2.isConnected() ? "подключен" : "отключен"));
        System.out.println("Роутер " + r3.getModel() + ": " + (r3.isConnected() ? "подключен" : "отключен"));
        System.out.println("Компьютер " + c1.getModel() + ": " + (c1.isConnected() ? "подключен" : "отключен"));
        System.out.println("Компьютер " + c2.getModel() + ": " + (c2.isConnected() ? "подключен" : "отключен"));
    }
}