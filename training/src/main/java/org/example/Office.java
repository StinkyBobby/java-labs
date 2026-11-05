package org.example;

public class Office extends Building {
    private int employees;

    public Office(String address, int floors, double area, int employees) {
        super(address, floors, area);
        this.employees = employees;
    }

    @Override
    public void getPurpose() {
        System.out.println("Офис");
    }

    protected void build(String material, int floors) {
        System.out.println("Строю офис из материала " + material + ", этажей: " + floors);
    }


}
