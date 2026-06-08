import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    @Test
    @DisplayName("Should successfully read players from a valid JSON file")
    void testReadInput_Success() {
        FileReader fileReader = new FileReader("test_valid_players.json");
        List<TableTennisPlayer> players = fileReader.readInput();

        assertNotNull(players, "Players list should not be null");
        assertEquals(2, players.size(), "Should successfully read exactly 2 players");

        TableTennisPlayer first = players.get(0);
        assertEquals("Игорь", first.getName());
        assertEquals(50, first.getTotalGames());
        assertEquals(42, first.getWonGames());

        TableTennisPlayer second = players.get(1);
        assertEquals("Алексей", second.getName());
        assertEquals(30, second.getTotalGames());
        assertEquals(15, second.getWonGames());
    }

    @Test
    @DisplayName("Should skip players with invalid data according to business rules")
    void testReadInput_WithInvalidPlayers() {
        FileReader fileReader = new FileReader("test_mixed_players.json");
        List<TableTennisPlayer> players = fileReader.readInput();

        assertNotNull(players);
        assertEquals(1, players.size(), "Players with invalid values must be skipped");
        assertEquals("Алексей", players.get(0).getName());
    }

    @Test
    @DisplayName("Should skip a player if a required field is missing in JSON")
    void testReadInput_MissingRequiredField() {
        FileReader fileReader = new FileReader("test_missing_field_players.json");
        List<TableTennisPlayer> players = fileReader.readInput();

        assertNotNull(players);
        assertEquals(1, players.size(), "Player without a required field must be skipped");
        assertEquals("ValidPlayer", players.get(0).getName(), "Valid player from the same file should be successfully loaded");
    }

    @Test
    @DisplayName("Should return an empty list when the resource file is not found")
    void testReadInput_FileNotFound() {
        FileReader fileReader = new FileReader("non_existent_file.json");
        List<TableTennisPlayer> players = fileReader.readInput();

        assertNotNull(players);
        assertTrue(players.isEmpty(), "Should return an empty list if the file is missing");
    }

    @Test
    @DisplayName("Should return an empty list when the JSON syntax is corrupted")
    void testReadInput_CorruptedJson() {
        FileReader fileReader = new FileReader("test_corrupted_players.json");
        List<TableTennisPlayer> players = fileReader.readInput();

        assertNotNull(players);
        assertTrue(players.isEmpty(), "Should return an empty list on syntax errors in the file");
    }
}
