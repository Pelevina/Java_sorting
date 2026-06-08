import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleReaderTest {

    private final ByteArrayInputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        // Сохраняем оригинальный System.in, чтобы потом восстановить
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
    }

    @Test
    void readInput_success_twoPlayers() {
        // Подготавливаем входные данные: имитация ввода пользователя
        String input = """
                Player 1
                10
                3
                Player 2
                20
                5
                """;
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        ConsoleReader reader = new ConsoleReader(2);
        List<TableTennisPlayer> players = reader.readInput();

        assertEquals(2, players.size());

        TableTennisPlayer p1 = players.get(0);
        assertEquals("Player 1", p1.getName());
        assertEquals(10, p1.getTotalGames());
        assertEquals(3, p1.getWonGames());

        TableTennisPlayer p2 = players.get(1);
        assertEquals("Player 2", p2.getName());
        assertEquals(20, p2.getTotalGames());
        assertEquals(5, p2.getWonGames());
    }

    @Test
    void readerNameAndCode() {
        ConsoleReader reader = new ConsoleReader(3);
        assertEquals("Console input", reader.getReaderName());
        assertEquals("console", reader.getCode());
    }

    @Test
    void readInput_handlesInvalidData_skipsBadEntry() {
        String input = """
                Good Player
                10
                3
                Bad Player
                not-a-number
                5
                Another Good
                20
                7
                """;
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        ConsoleReader reader = new ConsoleReader(3);
        List<TableTennisPlayer> players = reader.readInput();

        // Ожидается 2 игрока: первый и третий; второй был пропущен из-за ошибки
        assertEquals(2, players.size());

        TableTennisPlayer p1 = players.get(0);
        assertEquals("Good Player", p1.getName());
        assertEquals(10, p1.getTotalGames());
        assertEquals(3, p1.getWonGames());

        TableTennisPlayer p3 = players.get(1);
        assertEquals("Another Good", p3.getName());
        assertEquals(20, p3.getTotalGames());
        assertEquals(7, p3.getWonGames());
    }

    @Test
    void readInput_zeroLength_returnsEmptyList() {
        String input = "";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        ConsoleReader reader = new ConsoleReader(0);
        List<TableTennisPlayer> players = reader.readInput();

        assertTrue(players.isEmpty());
    }
}