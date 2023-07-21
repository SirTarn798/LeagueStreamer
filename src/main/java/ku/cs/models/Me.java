package ku.cs.models;

public class Me {
    private String id;
    private String name;
    private String nickName;
    private int yearBorn;

    public Me(String id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }
}