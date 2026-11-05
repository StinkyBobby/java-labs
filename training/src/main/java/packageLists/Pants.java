package packageLists;

public class Pants extends Garment{
    private double length;

    public Pants(String name, String id, String size, double length) {
        super(name, id, size);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Pants{" +
                "length=" + length +
                '}';
    }
}
