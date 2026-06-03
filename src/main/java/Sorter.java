import java.util.ArrayList;
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

    private List<TableTennisPlayer> merge(List<TableTennisPlayer> leftList, List<TableTennisPlayer> rightList, Comparator<TableTennisPlayer> comparator) {
        List<TableTennisPlayer> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        while (left < leftList.size() && right < rightList.size()) {
            if (comparator.compare(leftList.get(left), rightList.get(right)) < 0) {
                result.add(leftList.get(left));
                left++;
            }
            else {
                result.add(rightList.get(right));
                right++;
            }
        }
        while (left < leftList.size()) {
            result.add(leftList.get(left));
            left++;
        }
        while (right < leftList.size()) {
            result.add(leftList.get(right));
            right++;
        }
        return result;
    }

    private List<TableTennisPlayer> mergeSort(List<TableTennisPlayer> players, Comparator<TableTennisPlayer> comparator) {
        if (players.size() == 1) {
            return players;
        }
        int mid = players.size() / 2;
        List<TableTennisPlayer> left = mergeSort(players.subList(0, mid), comparator);
        List<TableTennisPlayer> right = mergeSort(players.subList(mid, players.size()), comparator);
        return merge(left, right, comparator);
    }

    public List<TableTennisPlayer> sortPlayers(Comparator<TableTennisPlayer> comparator) {
        return mergeSort(players, comparator);
    }
}
