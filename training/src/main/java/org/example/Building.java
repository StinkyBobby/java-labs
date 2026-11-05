package org.example;

public class Building {
    private String address;
    private int floors;
    private double area;

    public Building(String address, int floors, double area){
        this.address = address;
        this.floors = floors;
        this.area = area;
    }

    public String getAddress() {return address;}
    public int getFloors() {return floors;}
    public double getArea() {return area;}

    public void setAddress(String address) {this.address = address;}
    public void setArea(double area) {this.area = area;}
    public void setFloors(int floors) {this.floors = floors;}

    protected void build() {
        System.out.println("Строю здание");
    }

    protected void build(int floors){
        System.out.printf("Строю здание с %s этажами\n", floors);
    }

    protected void build(String material) {
        System.out.printf("Строю здание из %s\n", material);
    }


    public void getPurpose(){
        System.out.println("Неизвестно");
    }
}
