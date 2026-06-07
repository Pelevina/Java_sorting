import java.util.Comparator;
import java.util.Locale;
import java.text.Collator;

/* Компаратор в рамках основного задания будет таким:
сначала по количеству выигранных партий по возрастанию,
затем по количеству всех партий по убыванию,
затем по имени в лексикографическом порядке по возрастанию */

public class CompositComparator implements Comparator<TableTennisPlayer> {

    private final Collator collator;
    public CompositComparator() {
        this.collator = Collator.getInstance(Locale.of("ru", "RU"));
        this.collator.setStrength(Collator.SECONDARY);
    }

    @Override
    public int compare(TableTennisPlayer o1, TableTennisPlayer o2) {

        /*сравниваем кол-во побед по возрастанию*/
        if (o1.getWonGames() < o2.getWonGames()) return -1;
        if (o1.getWonGames() > o2.getWonGames()) return 1;

        /*сравниваем кол-во игр по убыванию*/
        if (o1.getTotalGames() < o2.getTotalGames()) return 1;
        if (o1.getTotalGames() > o2.getTotalGames()) return -1;

        /*сравниваем имена*/
        /* возвращает 1: если первый переданный объект лексикографически должен быть после второго переданного;
        возвращает -1: если первый переданный объект лексикографически должен быть перед вторым;
        возвращает 0: если объекты равны.*/
        return collator.compare(o1.getName(), o2.getName());
    }
}