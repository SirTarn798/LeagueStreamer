package ku.cs.models;

public class Me {
    private String id;
    private String name;
    private String nickName;
    private int yearBorn;

    public Me(String id, String name, String nickName, int yearBorn) {
        this.id = id;
        this.name = name;
        this.yearBorn = yearBorn;
        this.nickName = nickName;
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

    public String getNickName() {
        return nickName;
    }
}