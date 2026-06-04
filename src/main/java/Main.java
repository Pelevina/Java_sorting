import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter length of the collection: ");
        int lengthCollection = in.nextInt();

        in.nextLine();

        if (lengthCollection > 0) {
            Map<String, Reader> readerMap = new HashMap<>();
            Reader consoleReader = new ConsoleReader();
            Reader randomReader = new RandomReader();
            Reader fileReader = new FileReader();

            readerMap.put(consoleReader.getReaderName(), consoleReader);
            readerMap.put(randomReader.getReaderName(), randomReader);
            readerMap.put(fileReader.getReaderName(), fileReader);

            System.out.print("Enter the way of data input: ");
            String readerName = in.nextLine();

            if (readerMap.containsKey(readerName)) {
                List<TableTennisPlayer> players = readerMap.get(readerName).readInput();

                List<TableTennisPlayer> limitedPlayers = players.stream()
                        .limit(lengthCollection)
                        .toList();

                System.out.println("\n--- Valid players loaded successfully ---");

                limitedPlayers.forEach(p -> System.out.printf("Player: %-12s | Total Games: %-4d | Won Games: %-4d\n",
                        p.getName(), p.getTotalGames(), p.getWonGames()));
            } else {
                System.out.println("Wrong way of input");
            }
        } else {
            System.out.print("Wrong length of collection");
        }
    }
}
