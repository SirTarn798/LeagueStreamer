package ku.cs.models;
import java.util.ArrayList;

public class LeagueStreamerList {

    private ArrayList<LeagueStreamer> streamers;


    public LeagueStreamerList() {
        streamers = new ArrayList<>();
    }

    public void addNewStreamer(String name, String lane) {
        name = name.trim();
        if(!name.equals("")) {
            LeagueStreamer exist = findStreamerByName(name);
            if(exist == null) {
                streamers.add(new LeagueStreamer(name, lane));
            }
        }
    }

    public void addKills(String name, int kills) {
        LeagueStreamer exist = findStreamerByName(name);
        if(exist != null) {
            exist.addKills(kills);
        }
    }

    public void addDeaths(String name, int deaths) {
        LeagueStreamer exist = findStreamerByName(name);
        if(exist != null) {
            exist.addDeaths(deaths);
        }
    }

    public void addAssists(String name, int assists) {
        LeagueStreamer exist = findStreamerByName(name);
        if(exist != null) {
            exist.addAssists(assists);
        }
    }

    public LeagueStreamer findStreamerByName(String name) {
        for(LeagueStreamer streamer : streamers) {
            if(streamer.getName().equals(name)) {
                return streamer;
            }
        }
        return null;
    }

    public ArrayList<LeagueStreamer> getStreamers() {
        return streamers;
    }
}
