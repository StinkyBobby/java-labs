package packageLists;

public class Jacket extends Garment{
    private String material;

    public Jacket(String name, String id, String size, String material) {
        super(name, id, size);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Jacket{" +
                "material='" + material + '\'' +
                '}';
    }
}
