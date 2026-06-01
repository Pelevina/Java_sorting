import java.util.Comparator;
import java.util.List;

public class Sorter {
    private List<TableTennisPlayer> players;

    public Sorter(List<TableTennisPlayer> players) {
        this.players = players;
    }


    public List<TableTennisPlayer> getPlayers() {
        return players;
    }

    void sortPlayers(Comparator<TableTennisPlayer> comparator) {

    }
}
