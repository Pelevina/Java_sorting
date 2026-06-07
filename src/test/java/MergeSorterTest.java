import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MergeSorterTest {
    final CompositComparator comparator = new CompositComparator();

    TableTennisPlayer p1 = new TableTennisPlayer.Builder().setName("Иванов Иван").setTotalGames(120).setWonGames(100).build();
    TableTennisPlayer p2 = new TableTennisPlayer.Builder().setName("Денисов Денис").setTotalGames(199).setWonGames(122).build();
    TableTennisPlayer p3 = new TableTennisPlayer.Builder().setName("Сергеев Сергей").setTotalGames(11).setWonGames(3).build();
    TableTennisPlayer p4 = new TableTennisPlayer.Builder().setName("Максимов Максим").setTotalGames(25).setWonGames(10).build();
    TableTennisPlayer p5 = new TableTennisPlayer.Builder().setName("Михайлов Михаил").setTotalGames(50).setWonGames(44).build();
    TableTennisPlayer p6 = new TableTennisPlayer.Builder().setName("Борисов Борис").setTotalGames(76).setWonGames(70).build();
    TableTennisPlayer p7 = new TableTennisPlayer.Builder().setName("Никитин Никита").setTotalGames(34).setWonGames(12).build();
    TableTennisPlayer p8 = new TableTennisPlayer.Builder().setName("Алексеев Алексей").setTotalGames(121).setWonGames(90).build();
    TableTennisPlayer p9 = new TableTennisPlayer.Builder().setName("Андреев Андрей").setTotalGames(99).setWonGames(90).build();
    TableTennisPlayer p10 = new TableTennisPlayer.Builder().setName("Тимуров Тимур").setTotalGames(100).setWonGames(77).build();
    TableTennisPlayer p11 = new TableTennisPlayer.Builder().setName("Богданов Богдан").setTotalGames(98).setWonGames(62).build();
    TableTennisPlayer p12 = new TableTennisPlayer.Builder().setName("Алексанров Александр").setTotalGames(7).setWonGames(2).build();
    TableTennisPlayer p13 = new TableTennisPlayer.Builder().setName("Романов Роман").setTotalGames(211).setWonGames(163).build();
    TableTennisPlayer p14 = new TableTennisPlayer.Builder().setName("Игорев Игорь").setTotalGames(221).setWonGames(122).build();
    TableTennisPlayer p15 = new TableTennisPlayer.Builder().setName("Егоров Егор").setTotalGames(77).setWonGames(77).build();
    TableTennisPlayer p16 = new TableTennisPlayer.Builder().setName("Павлов Павел").setTotalGames(200).setWonGames(90).build();
    TableTennisPlayer p17 = new TableTennisPlayer.Builder().setName("Матвеев Матвей").setTotalGames(34).setWonGames(12).build();
    TableTennisPlayer p18 = new TableTennisPlayer.Builder().setName("Тимофеев Тимофей").setTotalGames(144).setWonGames(79).build();
    TableTennisPlayer p19 = new TableTennisPlayer.Builder().setName("Артемов Артем").setTotalGames(20).setWonGames(7).build();
    TableTennisPlayer p20 = new TableTennisPlayer.Builder().setName("Миронов Мирон").setTotalGames(22).setWonGames(7).build();
    TableTennisPlayer p21 = new TableTennisPlayer.Builder().setName("Васильев Василий").setTotalGames(91).setWonGames(44).build();
    TableTennisPlayer p22 = new TableTennisPlayer.Builder().setName("Антонов Антон").setTotalGames(211).setWonGames(163).build();
    TableTennisPlayer p23 = new TableTennisPlayer.Builder().setName("Макаров Макар").setTotalGames(211).setWonGames(163).build();
    TableTennisPlayer p24 = new TableTennisPlayer.Builder().setName("Петров Петр").setTotalGames(199).setWonGames(144).build();
    TableTennisPlayer p25 = new TableTennisPlayer.Builder().setName("Семенов Семен").setTotalGames(55).setWonGames(44).build();

    public MergeSorterTest() throws InvalidDataException {
    }

    @Test
    void testListSize() {
        List<TableTennisPlayer> list = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13,
                p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25));
        List<TableTennisPlayer> sortedList = MergeSorter.mergeSort(list, comparator);
        assertEquals(list.size(), sortedList.size());
    }

    @Test
    public void testSorterResult() {
        List<TableTennisPlayer> list = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5));
        List<TableTennisPlayer> expectedList = new ArrayList<>(Arrays.asList(p3, p4, p5, p1, p2));
        List<TableTennisPlayer> sortedList = MergeSorter.mergeSort(list, comparator);
        assertEquals(expectedList, sortedList);
    }

    @Test
    void testAlreadySorted() {
        List<TableTennisPlayer> list = new ArrayList<>(Arrays.asList(p3, p4, p5, p1, p2));
        List<TableTennisPlayer> sortedList = MergeSorter.mergeSort(list, comparator);
        assertEquals(list, sortedList);
    }

    @Test
    void testEmptyList() {
        List<TableTennisPlayer> list = new ArrayList<>();
        MergeSorter.mergeSort(list, comparator);
        assertTrue(list.isEmpty());
    }

    @Test
    void testSingleElement() {
        List<TableTennisPlayer> list = new ArrayList<>();
        list.add(p1);
        List<TableTennisPlayer> sortedList = MergeSorter.mergeSort(list, comparator);
        assertEquals(list, sortedList);
    }

    @Test
    void testNullArguments() {
        boolean exception = false;
        List<TableTennisPlayer> list = new ArrayList<>();
        try {
            MergeSorter.mergeSort(null, comparator);
        } catch (IllegalArgumentException e) {
            exception = true;
        }
        assertTrue(exception);

        exception = false;
        list.add(p1);
        try {
            MergeSorter.mergeSort(list, null);
        } catch (IllegalArgumentException e) {
            exception = true;
        }
        assertTrue(exception);
    }

    @Test
    void testSourceListIsNotMutated() {
        List<TableTennisPlayer> sourceList = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5));
        List<TableTennisPlayer> sourceCopy = new ArrayList<>(sourceList);
        List<TableTennisPlayer> sortedList = MergeSorter.mergeSort(sourceList, comparator);
        assertEquals(sourceCopy, sourceList);
    }

    @Test
    void testStability() throws InvalidDataException {
        TableTennisPlayer pl1 = new TableTennisPlayer.Builder().setName("а").setTotalGames(20).setWonGames(10).build(); //первый в списке
        TableTennisPlayer pl2 = new TableTennisPlayer.Builder().setName("а").setTotalGames(20).setWonGames(10).build(); //второй в списке
        TableTennisPlayer pl3 = new TableTennisPlayer.Builder().setName("а").setTotalGames(20).setWonGames(10).build(); //третий в списке
        List<TableTennisPlayer> list = new ArrayList<>(Arrays.asList(pl1, pl2, pl3));
        List<TableTennisPlayer> sorted = MergeSorter.mergeSort(list, comparator);

        /*сравнение ссылок элементов со ссылками элементов в отсортированном списке*/
        assertSame(pl1, sorted.get(0));
        assertSame(pl2, sorted.get(1));
        assertSame(pl3, sorted.get(2));
    }
}
