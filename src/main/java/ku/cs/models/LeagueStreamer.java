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

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public void setAssists(int assists) {
        this.assists = assists;
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
