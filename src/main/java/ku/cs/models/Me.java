package ku.cs.models;

public class Me {
    private String id;
    private String name;

    private int yearBorn;

    public Me(String id, String name, int yearBorn) {
        this.id = id;
        this.name = name;
        this.yearBorn = yearBorn;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getYearBorn() {
        return yearBorn;
    }

    public int getAge() {
        return 2023-this.yearBorn;
    }
}