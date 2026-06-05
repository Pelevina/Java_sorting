import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

public class FileReader implements Reader {
    private static final String FILE_NAME = "players.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<TableTennisPlayer> readInput() {

        System.out.println("[INFO] Start reading file: " + FILE_NAME);
        try (
                InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILE_NAME)) {
            if (inputStream == null) {
                System.err.println("[ERROR] File " + FILE_NAME + " not found in resources!");
                return List.of();
            }
            List<TableTennisPlayerDto> dtos = objectMapper.readValue(
                    inputStream, new TypeReference<List<TableTennisPlayerDto>>() {
                    }
            );
            if (dtos == null) {
                return List.of();
            }

            return dtos.stream()
                    .map(this::mapDtoToPlayer)
                    .filter(Objects::nonNull)
                    .toList();
        } catch (
                IOException e) {
            System.err.println("[ERROR] Critical JSON structure error! Reading aborted. Reason: " + e.getMessage());
            return List.of();
        }
    }
    private TableTennisPlayer mapDtoToPlayer(TableTennisPlayerDto dto) {
        try {
            return new TableTennisPlayer.Builder()
                    .setName(dto.name)
                    .setTotalGames(dto.totalGames)
                    .setWonGames(dto.wonGames)
                    .build();
        } catch (InvalidDataException | RuntimeException e) {
            String dtoInfo = dto != null ? String.format("{name='%s', total=%s, won=%s}", dto.name, dto.totalGames, dto.wonGames) : "null";
            System.out.println("[WARN] Player skipped. Data: " + dtoInfo + ". Reason: " + e.getMessage());
            return null;
        }
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

