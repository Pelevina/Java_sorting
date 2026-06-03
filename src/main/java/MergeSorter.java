import java.util.*;

public class MergeSorter {

    private static void mergeSort(List<TableTennisPlayer> list, Comparator<TableTennisPlayer> comparator) {
        TableTennisPlayer[] arr = list.toArray(new TableTennisPlayer[0]); //преобразование списка в массив
        mergeSort(arr, comparator); //рекурсивный вызов перегруженного mergeSort()

        list.clear(); //отчистка списка

        for(TableTennisPlayer p: arr) { //запись отсортированных объектов в список
            list.add(p);
        }
    }

    private static void mergeSort(TableTennisPlayer[] arr, Comparator<TableTennisPlayer> comparator) {
        int n = arr.length; //длина массива
        if (n==1) return; //условия для окончания рекурсии
        int mid = n / 2; //середина массива
        TableTennisPlayer[] l = new TableTennisPlayer[mid]; //левая часть
        TableTennisPlayer[] r = new TableTennisPlayer[n - mid]; //правая часть

        /*Заполнение левого массива*/
        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }

        /*Заполнение правого массива*/
        for(int i = 0; i < r.length; i++) {
            r[i] = arr[i + mid];
        }

        mergeSort(l, comparator); //рекурсивный вызов перегруженного mergeSort() для левой части
        mergeSort(r, comparator); //рекурсивный вызов перегруженного mergeSort() для правой части

        merge(arr, l, r, comparator); //слияние отсортированных частей в один массив
    }

    private static void merge(TableTennisPlayer[] arr, TableTennisPlayer[] l, TableTennisPlayer[] r, Comparator<TableTennisPlayer> comparator) {
        int left = l.length; //длина левого массива
        int right = r.length; //длина правого массива
        int i = 0; //индекс в левом массиве
        int j = 0; //индекс в правом массиве
        int idx = 0; //индекс в общем массиве

        /*сравнение и запись значения в ячейках через компаратор*/
        while (i < left && j < right) {
            if (comparator.compare(l[i], r[j]) <= 0) {
                arr[idx] = l[i];
                i++;
                idx++;
            } else {
                arr[idx] = r[j];
                j++;
                idx++;
            }
        }

        for (int ll = i; ll < left; ll++) {
            arr[idx++] = l[ll];
        }
        for (int rr = j; rr < right; rr++) {
            arr[idx++] = r[rr];
        }
    }

    public static void main(String[] args) throws InvalidDataException {
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

        List<TableTennisPlayer> list = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13,
                p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25));

        List<TableTennisPlayer> list2 = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13,
                p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25));

        CompositComparator comparator = new CompositComparator();

        long l0 = System.currentTimeMillis();
        mergeSort(list, comparator);
        long l1 = System.currentTimeMillis();
        long time1 = l1-l0;
        IO.println("Время1: " + time1);
        IO.println(list);

        long l2 = System.currentTimeMillis();
        Collections.sort(list2, comparator);
        long l3 = System.currentTimeMillis();
        long time2 = l3-l2;
        IO.println("Время2: " + time2);
        IO.println(list2);
    }
}