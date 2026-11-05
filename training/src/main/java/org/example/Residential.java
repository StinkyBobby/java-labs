package org.example;

public class Residential extends Building {
    private int apartments;

    public Residential(String address, int floors, double area, int apartments){
        super(address, floors, area);
        this.apartments = apartments;
    }

    public int getApartments() {return apartments;}
    public void setApartments(int apartments) {this.apartments = apartments;}


    @Override
    public void getPurpose(){
        System.out.println("Дом для жилья");
    }

    protected void build(int floors, String material) {
        System.out.println("Строю жилой дом: " + floors + " этажей, материал: " + material);
    }

}
