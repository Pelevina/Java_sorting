import java.util.List;

public class FileReader implements Reader{
    @Override
    public List<TableTennisPlayer> readInput() {
        return List.of();
    }

    @Override
    public String getReaderName() {
        return "File input";
    }

    @Override
    public String getCode() {
        return "file";
    }
}
