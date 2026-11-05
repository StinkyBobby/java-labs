package Exceptions;

public class App {
    public static void main(String[] args) {
        Fleet fleet = new Fleet();

        System.out.println("ИНИЦИАЛИЗАЦИЯ АВТОПАРКА И ДОБАВЛЕНИЕ ТРАНСПОРТА");
        try {
            Transport t1 = new Transport("Автобус", "Mercedes", 2018, 45, 25.5);
            Transport t2 = new Transport("Грузовик", "Volvo", 2015, 2, 38.0);
            Transport t3 = new Transport("Легковой", "Toyota", 2022, 5, 7.2);


            fleet.addTransport(t1);
            fleet.addTransport(t2);
            fleet.addTransport(t3);


            fleet.listTransports();
        } catch (InvalidTransportDataException e) {

        }

        try {
            Transport t4 = new Transport("Трамвай", "Марка", 1000, 5, 7.2);
            fleet.addTransport(t4);
        } catch (InvalidTransportDataException e) {
            System.err.println("Ошибка данных: " + e.getMessage());
        }

        System.out.println("\nПРОВЕРКА ВАЛИДАЦИИ КОНСТРУКТОРА (Исключение InvalidTransportDataException)");
        try {
            Transport invalidTransport = new Transport("Ретро", "Ford Model T", 1890, 2, 12.0);
            fleet.addTransport(invalidTransport);
        } catch (InvalidTransportDataException e) {
            System.out.println("Неверные данные транспорта: " + e.getMessage());
        }

        System.out.println("\nОПЕРАЦИИ ОБСЛУЖИВАНИЯ (MaintenanceException)");
        try {
            fleet.performMaintenance("Mercedes");

            System.out.println("\nПопытка повторного обслуживания того же транспорта:");


            fleet.performMaintenance("Mercedes");
        } catch (TransportNotFoundException | MaintenanceException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\nПОИСК И ОБСЛУЖИВАНИЯ НЕСУЩЕСТВУЮЩЕГО ТРАНСПОРТА (TransportNotFoundException)");
        try {
            fleet.performMaintenance("Tesla");
        } catch (TransportNotFoundException e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        } catch (MaintenanceException e) {
            System.out.println("Ошибка обслуживания: " + e.getMessage());
        }

        System.out.println("\nРАСЧЕТ РАСХОДА ТОПЛИВА");
        try {
            Transport toyota = fleet.findByBrand("Toyota");
            double distance = 350.0;
            double fuel = toyota.calculateFuel(distance);
            System.out.printf("Для поездки на автомобиле %s на расстояние %.1f км потребуется: %.2f литров топлива.\n",
                    toyota.getBrand(), distance, fuel);
        } catch (TransportNotFoundException | InvalidTransportDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
