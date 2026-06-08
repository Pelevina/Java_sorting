import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleReader implements Reader{
    private final int length; // ограничение на количесвто создаваемых игроков

    public ConsoleReader(int length) {
        this.length = length;
    }

    @Override
    public List<TableTennisPlayer> readInput() {
        Scanner in = new Scanner(System.in);
        List<TableTennisPlayer> players = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            System.out.println("Player #" + (i + 1) + ":");

            try {
                System.out.print("name - ");
                String name = in.nextLine();

                System.out.print("total games - ");
                int totalGames = in.nextInt();
                in.nextLine();

                System.out.print("won games - ");
                int wonGames = in.nextInt();
                in.nextLine();

                players.add(new TableTennisPlayer.Builder()
                        .setName(name)
                        .setTotalGames(totalGames)
                        .setWonGames(wonGames)
                        .build());
            }
            catch (InvalidDataException e) {
                i--;
                System.out.println("Data wrong: " + e.getMessage());
            }
        }

        return players;
    }

    @Override
    public String getReaderName() {
        return "Console input";
    }

    @Override
    public String getCode() {
        return "console";
    }
}
