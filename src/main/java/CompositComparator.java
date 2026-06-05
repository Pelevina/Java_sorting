import java.util.Comparator;

/* Компаратор в рамках основного задания будет таким:
сначала по количеству выигранных партий по возрастанию,
затем по количеству всех партий по убыванию,
затем по имени в лексикографическом порядке по возрастанию */

public class CompositComparator implements Comparator<TableTennisPlayer> {
    @Override
    public int compare(TableTennisPlayer o1, TableTennisPlayer o2) {

        /*сравниваем кол-во побед по возрастанию*/
        if (o1.getWonGames() < o2.getWonGames()) return -1;
        if (o1.getWonGames() > o2.getWonGames()) return 1;

        /*сравниваем кол-во игр по убыванию*/
        if (o1.getTotalGames() < o2.getTotalGames()) return 1;
        if (o1.getTotalGames() > o2.getTotalGames()) return -1;

        /*сравниваем имена*/
        return o1.getName().compareTo(o2.getName());
    }
}
