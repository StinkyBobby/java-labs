package Exceptions;

public class Transport {
    private String type;
    private String brand;
    private int year;
    private int capacity;
    private double fuelConsumption;
    private boolean needsService;

    public Transport(String type, String brand, int year, int capacity, double fuelConsumption) throws InvalidTransportDataException {
        setYear(year);
        setCapacity(capacity);
        setFuelConsumption(fuelConsumption);

        this.type = type;
        this.brand = brand;
        this.needsService = true;
    }

    public void service() throws MaintenanceException {
        if (!needsService) {
            throw new MaintenanceException("Транспорт '" + brand + " (" + type + ")' уже обслужен и не нуждается в повторном ТО.");
        }
        System.out.println("Проведение технического обслуживания: " + brand + " (" + type + ")...");
        this.needsService = false;
        System.out.println("Обслуживание успешно завершено.");
    }

    public double calculateFuel(double distance) throws InvalidTransportDataException {
        if (distance < 0) {
            throw new InvalidTransportDataException("Расстояние не может быть отрицательным.");
        }
        return (fuelConsumption * distance) / 100.0;
    }

    public String getType() { return type; }
    public String getBrand() { return brand; }
    public int getYear() { return year; }
    public int getCapacity() { return capacity; }
    public double getFuelConsumption() { return fuelConsumption; }
    public boolean isNeedsService() { return needsService; }

    public void setType(String type)  {
        this.type = type;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setYear(int year) throws InvalidTransportDataException {
        if (year <= 1900) {
            throw new InvalidTransportDataException("Год выпуска должен быть больше 1900. Передано: " + year);
        }
        this.year = year;
    }

    public void setCapacity(int capacity) throws InvalidTransportDataException {
        if (capacity <= 0) {
            throw new InvalidTransportDataException("Вместимость должна быть больше 0. Передано: " + capacity);
        }
        this.capacity = capacity;
    }

    public void setFuelConsumption(double fuelConsumption) throws InvalidTransportDataException {
        if (fuelConsumption < 0) {
            throw new InvalidTransportDataException("Расход топлива не может быть отрицательным.");
        }
        this.fuelConsumption = fuelConsumption;
    }

    public void setNeedsService(boolean needsService) {
        this.needsService = needsService;
    }

    @Override
    public String toString() {
        return String.format("Transport [Тип: %s, Бренд: %s, Год: %d, Вместимость: %d мест, Расход: %.1f л/100км, Требует ТО: %b]",
                type, brand, year, capacity, fuelConsumption, needsService);
    }
}
