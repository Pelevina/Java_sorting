import java.util.List;

public class ConsoleReader implements Reader{
    @Override
    public List<TableTennisPlayer> readInput() {
        return List.of();
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
