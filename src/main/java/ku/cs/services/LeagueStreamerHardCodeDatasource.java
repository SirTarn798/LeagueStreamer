package ku.cs.services;
import ku.cs.models.LeagueStreamer;
import ku.cs.models.LeagueStreamerList;
public class LeagueStreamerHardCodeDatasource {
    public LeagueStreamerList readData() {
        LeagueStreamerList list = new LeagueStreamerList();
        list.addNewStreamer("Thebausffs", "Top");
        list.addNewStreamer("Caedrel", "Top");
        list.addNewStreamer("Nemesis", "Mid");
        list.addNewStreamer("Broxah", "Jungle");
        list.addNewStreamer("Rekkles", "Bot");
        return list;
    }
}
