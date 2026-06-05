import java.util.*;

public class MergeSorter {

    public static List<TableTennisPlayer> mergeSort(List<TableTennisPlayer> list, Comparator<TableTennisPlayer> comparator) {
        if (list == null || comparator == null) { //проверка аргументов на null
            throw new IllegalArgumentException("Arguments must not be null");
        }

        if (list.size() <=1) { //проверка размера входящего списка
            return new ArrayList<>(list);
        }

        TableTennisPlayer[] arr = list.toArray(new TableTennisPlayer[0]); //преобразование списка в массив
        mergeSort(arr, comparator); //рекурсивный вызов перегруженного mergeSort()
        return new ArrayList<>(Arrays.asList(arr)); //возврат отсортированного списка
    }

    private static void mergeSort(TableTennisPlayer[] arr, Comparator<TableTennisPlayer> comparator) {
        int n = arr.length; //длина массива
        if (n<=1) return; //условия для окончания рекурсии
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
}