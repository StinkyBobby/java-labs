package packageLists;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Programmer {
    private int id;
    private String name;
    private String language;
    private int level;
    private List<Integer> codeReviews;

    public Programmer(int id, String name, String language, int level) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.level = level;
    }

    public Programmer(int id, String name, String language, int level, List<Integer> codeReviews) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.level = level;
        this.codeReviews = codeReviews;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Integer> getCodeReviews() {
        return codeReviews;
    }

    public void setCodeReviews(List<Integer> codeReviews) {
        this.codeReviews = codeReviews;
    }

    public double averageRating() {
        int temp = 0;
        int counter = 0;

        if(codeReviews == null) {
            return 0.0;
        }
        else {
            for (int el : codeReviews) {
                temp += el;
                counter ++;
            }

            return (double) temp / counter;
        }
    }

    public static void printProgrammers(List<Programmer> programmers, int level) {
        for (Programmer el : programmers) {
            if (!programmers.isEmpty()) {
                if(el.getLevel() == level) {
                    System.out.println(el);
                }
            }
            else {
                System.out.println("Нет программистов с подходщим уровнем");
            }
        }
    }

    public static void sortAndPrint(List<Programmer> programmers) {
        List<Programmer> sorted = new ArrayList<>(programmers);
        sorted.sort(
                Comparator.comparingDouble(Programmer::averageRating).reversed().thenComparing(Programmer::getName, Comparator.reverseOrder())


        );
        System.out.println("Программисты оп убыванию");
        System.out.printf("%-5s %-20s %-10s%n", "ID", "Имя", "Ср. рейтинг");
        for (Programmer p : sorted) {
            System.out.printf("%-5d %-20s %.2f%n", p.getId(), p.getName(), p.averageRating());
        }
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", level=" + level +
                ", codeReviews=" + codeReviews +
                '}';
    }
}
