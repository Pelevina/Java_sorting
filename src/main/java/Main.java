import java.util.*;

public class Main {
    private static final Map<String, Reader> readerMap = new HashMap<>();

    public static void main(String[] args) {
        boolean run = true;

        while (run) {
            run = !start();
        }
    }

    private static boolean start() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter length of the collection: ");

        int lengthCollection = in.nextInt();

        in.nextLine(); // предотвращаем считывание избыточного переноса строки при следующем вводе данных

        if (lengthCollection > 0) {
            Reader consoleReader = new ConsoleReader(lengthCollection);
            Reader randomReader = new RandomReader(lengthCollection);//добавила lengthCollection,чтобы RandomReader знал сколько игроков генерировать.
            Reader fileReader = new FileReader();

            readerMap.put(consoleReader.getCode(), consoleReader);
            readerMap.put(randomReader.getCode(), randomReader);
            readerMap.put(fileReader.getCode(), fileReader);

            String input = "", readerName = "";

            List<TableTennisPlayer> players = List.of();

            while (true) {
                switch (input) {
                    case "?":
                    case "h":
                    case "help":
                        printHelp(!readerName.isBlank());
                        break;
                    case "q":
                    case "quit":
                        return true;
                    case "r":
                    case "reset":
                        return false;
                    case "s":
                    case "sort":
                        if(!players.isEmpty()) {
                        	List<TableTennisPlayer> sortedPlayers = MergeSorter.mergeSort(players, new CompositComparator());
                        	System.out.println(sortedPlayers);
                        } else {
                            System.out.println("Empty player list");
                        }

                        break;
                    default:
                        if (readerMap.containsKey(input)) {
                            readerName = input;
                            players = readerMap.get(readerName).readInput();
                            System.out.println(players);
                        } else if (!input.isBlank()) {
                            System.out.println("Wrong command");
                        }
                }

                if(readerName.isBlank()) {
                    System.out.print("Enter the way of data input (? for help): ");
                } else {
                    System.out.print("Enter command (? for help): ");
                }

                input = in.nextLine();
            }
        } else {
            System.out.println("Wrong length of collection");
        }

        return true;
    }

    private static void printHelp(boolean withReaderList) {
        System.out.println("?, h, help - Help");
        System.out.println("s, sort - Sort");
        System.out.println("r, reset - Reset");
        System.out.println("q, quit - Quit");

        if(withReaderList) {
            readerMap.forEach((key, val) -> System.out.println(val.getCode() + " - " + val.getReaderName()));
        }
    }
}