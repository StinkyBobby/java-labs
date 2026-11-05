package Exceptions;

import java.util.List;
import java.util.ArrayList;

public class Fleet {
    private List<Transport> transports;

    public Fleet() {
        this.transports = new ArrayList<>();
    }

    public void addTransport(Transport transport) {
        transports.add(transport);
    }

    public Transport findByBrand(String brand) throws TransportNotFoundException {
        for (Transport t : transports) {
            if (t.getBrand().equalsIgnoreCase(brand)) {
                return t;
            }
        }
        throw new TransportNotFoundException("Транспорт с брендом '" + brand + "' не найден в автопарке.");
    }

    public void performMaintenance(String brand) throws TransportNotFoundException, MaintenanceException {
        Transport transport = findByBrand(brand);
        transport.service();
    }

    public void listTransports() {
        if (transports.isEmpty()) {
            System.out.println("Автопарк пуст.");
            return;
        }
        System.out.println("Текущий состав автопарка:");
        for (Transport t : transports) {
            System.out.println(t);
        }
    }
}