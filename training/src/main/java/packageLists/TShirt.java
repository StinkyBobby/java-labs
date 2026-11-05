package packageLists;

public class TShirt extends Garment{
    private String print;

    public TShirt(String name, String id, String size, String print) {
        super(name, id, size);
        this.print = print;
    }

    public String getPrint() {
        return print;
    }

    public void setPrint(String print) {
        this.print = print;
    }

    @Override
    public String toString() {
        return "TShirt{" +
                "print='" + print + '\'' +
                '}';
    }
}
