import java.util.List;

public class RandomReader implements Reader{
    @Override
    public List<TableTennisPlayer> readInput() {
        return List.of();
    }

    @Override
    public String getReaderName() {
        return "Random input";
    }

    @Override
    public String getCode() {
        return "random";
    }
}
