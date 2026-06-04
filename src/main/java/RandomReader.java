import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomReader implements Reader {

    private final int length; // сколько игроков создать
    private static final String[] NAMES = {
            "Алекс", "Мария", "Иван", "Ольга", "Дмитрий", "Анна", "Никита", "Дарья"
    };
    private static final Random RANDOM = new Random();

    // принимаем длину из Main
    public RandomReader(int length) {
        this.length = length;
    }

    @Override
    public List<TableTennisPlayer> readInput() {
        List<TableTennisPlayer> players = new ArrayList<>();

        for (int i = 0; i < length; i++) { // повторяем столько раз сколько ввёл пользователь
            try {
                String name = NAMES[RANDOM.nextInt(NAMES.length)]; // случайное имя из массива
                int totalGames = RANDOM.nextInt(100) + 1;          // случайное число от 1 до 100
                int wonGames = RANDOM.nextInt(totalGames + 1);      // от 0 до totalGames

                players.add(new TableTennisPlayer.Builder()
                        .setName(name)
                        .setTotalGames(totalGames)
                        .setWonGames(wonGames)
                        .build());
            } catch (InvalidDataException e) {
                System.out.println("Ошибка генерации: " + e.getMessage());
            }
        }

        return players; // возвращаем готовый список
    }

    @Override
    public String getReaderName() {
        return "Random input";
    }
}