package org.example;

public class App 
{
    public static void main( String[] args )
    {
        Residential house = new Residential("ул. Ленина, 10", 5, 1200.5, 40);
        Office office = new Office("ул. Центральная, 25", 12, 3500, 200);


        System.out.println("=== ПЕРЕГРУЗКА ===");
        house.build();
        house.build(7);
        house.build("кирпича");
        house.build(5, "бетон");
        office.build("стекла", 12);


        System.out.println("\n=== ПЕРЕОПРЕДЕЛЕНИЕ ===");
        house.getPurpose();
        office.getPurpose();


    }
}
