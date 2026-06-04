import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter length of the collection: ");
        int lengthCollection = in.nextInt();
        in.nextLine(); // добавила очистку буфера после nextInt()
        if (lengthCollection > 0) {
            Map<String, Reader> readerMap = new HashMap<>();
            Reader consoleReader = new ConsoleReader();
            Reader randomReader = new RandomReader(lengthCollection);//добавила lengthCollection,чтобы RandomReader знал сколько игроков генерировать.
            Reader fileReader = new FileReader();
            readerMap.put(consoleReader.getReaderName(), consoleReader);
            readerMap.put(randomReader.getReaderName(), randomReader);
            readerMap.put(fileReader.getReaderName(), fileReader);
            System.out.print("Enter the way of data input: ");
            String readerName = in.nextLine();
            if (readerMap.containsKey(readerName)) {
                List<TableTennisPlayer> players = readerMap.get(readerName).readInput();
                //добавила вывод на экран
                for (TableTennisPlayer player : players) {
                    System.out.println(player.getName() + " | games: " + player.getTotalGames() + " | won: " + player.getWonGames());
                }
            } else {
                System.out.println("Wrong way of input");
            }
        } else {
            System.out.print("Wrong length of collection");
        }
    }
}
