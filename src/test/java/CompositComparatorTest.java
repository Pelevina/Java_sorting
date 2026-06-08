import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompositComparatorTest {

   private final CompositComparator comparator = new CompositComparator();

    @Test
    void testWonGames() throws InvalidDataException {
        TableTennisPlayer p1 = new TableTennisPlayer.Builder().setName("Иванов Иван").setTotalGames(120).setWonGames(100).build();
        TableTennisPlayer p2 = new TableTennisPlayer.Builder().setName("Денисов Денис").setTotalGames(199).setWonGames(122).build();
        assertTrue(comparator.compare(p1, p2) < 0);
    }

    @Test
    void testTotalGames() throws InvalidDataException {
        TableTennisPlayer p1 = new TableTennisPlayer.Builder().setName("Сергеев Сергей").setTotalGames(11).setWonGames(1).build();
        TableTennisPlayer p2 = new TableTennisPlayer.Builder().setName("Максимов Максим").setTotalGames(25).setWonGames(1).build();
        assertTrue(comparator.compare(p1, p2) > 0);
    }

    @Test
    void testName() throws InvalidDataException {
        TableTennisPlayer p1 = new TableTennisPlayer.Builder().setName("Алексеев Алексей").setTotalGames(1).setWonGames(1).build();
        TableTennisPlayer p2 = new TableTennisPlayer.Builder().setName("Алексеев Богдан").setTotalGames(1).setWonGames(1).build();
        TableTennisPlayer p3 = new TableTennisPlayer.Builder().setName("Алексеев Ян").setTotalGames(1).setWonGames(1).build();
        TableTennisPlayer p4 = new TableTennisPlayer.Builder().setName("Алексеев Мирон").setTotalGames(1).setWonGames(1).build();
        TableTennisPlayer p5 = new TableTennisPlayer.Builder().setName("Денисов Денис").setTotalGames(1).setWonGames(1).build();
        TableTennisPlayer p6 = new TableTennisPlayer.Builder().setName("Денисов денис").setTotalGames(1).setWonGames(1).build();
        assertTrue(comparator.compare(p1, p2) < 0);
        assertTrue(comparator.compare(p3, p4) > 0);
        assertEquals(0, comparator.compare(p5, p6));
    }

    @Test
    void testFullIdentity() throws InvalidDataException {
        TableTennisPlayer p1 = new TableTennisPlayer.Builder().setName("Валерий Валерьев").setTotalGames(100).setWonGames(100).build();
        TableTennisPlayer p2 = new TableTennisPlayer.Builder().setName("Валерий Валерьев").setTotalGames(100).setWonGames(100).build();
        assertEquals(0, comparator.compare(p1, p2));
    }

    @Test
    void testSymetry () throws InvalidDataException {
        TableTennisPlayer p1 = new TableTennisPlayer.Builder().setName("Иванов Иван").setTotalGames(120).setWonGames(100).build();
        TableTennisPlayer p2 = new TableTennisPlayer.Builder().setName("Денисов Денис").setTotalGames(199).setWonGames(122).build();
        assertTrue(comparator.compare(p1, p2) < 0);
        assertTrue(comparator.compare(p2, p1) > 0);
    }

    @Test
    void testTransitivity() throws InvalidDataException {
        //одинаковое кол-во побед
        TableTennisPlayer p1 = new TableTennisPlayer.Builder().setName("Андреев Андрей").setTotalGames(40).setWonGames(10).build();
        TableTennisPlayer p2 = new TableTennisPlayer.Builder().setName("Богданов Богдан").setTotalGames(20).setWonGames(10).build();
        TableTennisPlayer p3 = new TableTennisPlayer.Builder().setName("Васильев Василий").setTotalGames(10).setWonGames(10).build();
        assertTrue(comparator.compare(p1, p2) < 0);
        assertTrue(comparator.compare(p2, p3) < 0);
        assertTrue(comparator.compare(p1, p3) < 0);

        //одинаковое кол-во игр
        TableTennisPlayer p4 = new TableTennisPlayer.Builder().setName("Андреев Андрей").setTotalGames(40).setWonGames(20).build();
        TableTennisPlayer p5 = new TableTennisPlayer.Builder().setName("Богданов Богдан").setTotalGames(40).setWonGames(10).build();
        TableTennisPlayer p6 = new TableTennisPlayer.Builder().setName("Васильев Василий").setTotalGames(40).setWonGames(5).build();
        assertTrue(comparator.compare(p4, p5) > 0);
        assertTrue(comparator.compare(p5, p6) > 0);
        assertTrue(comparator.compare(p4, p6) > 0);

        //полное равенство
        TableTennisPlayer p7 = new TableTennisPlayer.Builder().setName("Андреев Андрей").setTotalGames(40).setWonGames(20).build();
        TableTennisPlayer p8 = new TableTennisPlayer.Builder().setName("Андреев Андрей").setTotalGames(40).setWonGames(20).build();
        TableTennisPlayer p9 = new TableTennisPlayer.Builder().setName("Андреев Андрей").setTotalGames(40).setWonGames(20).build();
        assertEquals(0, comparator.compare(p7, p8));
        assertEquals(0, comparator.compare(p8, p9));
        assertEquals(0, comparator.compare(p7, p9));
    }

    @Test
    void russianLocaleTest() throws InvalidDataException {
        TableTennisPlayer p1 = new TableTennisPlayer.Builder().setName("е").setTotalGames(2).setWonGames(1).build();
        TableTennisPlayer p2 = new TableTennisPlayer.Builder().setName("ё").setTotalGames(2).setWonGames(1).build();
        TableTennisPlayer p3 = new TableTennisPlayer.Builder().setName("ж").setTotalGames(2).setWonGames(1).build();
        TableTennisPlayer p4 = new TableTennisPlayer.Builder().setName("и").setTotalGames(2).setWonGames(1).build();
        TableTennisPlayer p5 = new TableTennisPlayer.Builder().setName("й").setTotalGames(2).setWonGames(1).build();
        TableTennisPlayer p6 = new TableTennisPlayer.Builder().setName("к").setTotalGames(2).setWonGames(1).build();
        assertTrue(comparator.compare(p1, p2) < 0);
        assertTrue(comparator.compare(p2, p3) < 0);
        assertTrue(comparator.compare(p4, p5) < 0);
        assertTrue(comparator.compare(p5, p6) < 0);
    }
}