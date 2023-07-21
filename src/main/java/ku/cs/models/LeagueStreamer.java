package ku.cs.models;

public class LeagueStreamer {
    private String name;
    private String lane;
    private int kills;
    private int deaths;
    private int assists;
    private double kda;

    public LeagueStreamer(String name, String lane, int kills, int deaths, int assists) {
        this.name = name;
        this.lane = lane;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
    }
    public LeagueStreamer(String name, String lane) {
        this.name = name;
        this.lane = lane;
        this.kills = 0;
        this.deaths = 0;
        this.assists = 0;
    }

    public void addKills(int kills) {
        this.kills += kills;
    }

    public void addDeaths(int deaths) {
        this.deaths += deaths;
    }

    public void addAssists(int assists) {
        this.assists += assists;
    }

    public String getName() {
        return name;
    }

    public String getLane() {
        return lane;
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getAssists() {
        return assists;
    }

    public double getKda() {
        if(deaths == 0) {
            return -1;
        }
        return (double)(this.kills+this.assists) / (double)this.deaths;
    }


}
