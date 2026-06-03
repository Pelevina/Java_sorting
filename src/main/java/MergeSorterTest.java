import java.util.Arrays;

/* Учебный пример сортировки слиянием */
public class MergeSorterTest {
    private  static  void mergeSort(int[] arr) {
        int n = arr.length;
        if (n==1) return;
        int mid = n/2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        /*Заполнение левого массива*/
        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }

        /*Заполнение правого массива*/
        for(int i = 0; i < r.length; i++) {
            r[i] = arr[i + mid];
        }

        mergeSort(l);
        mergeSort(r);
        
        merge(arr, l, r);
    }

    private static void merge(int[] arr, int[] l, int[] r) {
        int left = l.length;
        int right = r.length;
        int i = 0;
        int j = 0;
        int idx = 0;

        while (i < left && j < right) {
            if (l[i] < r[j]) {
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

    public static void main (String[] args) {


        int[] arr1 = {5, 1, 6, 9, 5, 3, 8, 11, 12, 14, 13,
                      25, 67, 0, 3, -1, 6, 6, 3, 1, -35, 49,
                        34, 100, -199, -355, 667};

        int[] arr2 = new int[] {5, 1, 6, 9, 5, 3, 8, 11, 12, 14, 13,
                25, 67, 0, 3, -1, 6, 6, 3, 1, -35, 49,
                34, 100, -199, -355, 667};

        IO.println(Arrays.toString(arr1));
        IO.println(Arrays.toString(arr2));

        long l0 = System.currentTimeMillis();
        long l1 = System.currentTimeMillis();
        mergeSort(arr1);
        IO.println(Arrays.toString(arr1));
        IO.println(l1-l0);

        long l2 = System.currentTimeMillis();
        Arrays.sort(arr2);
        IO.println(Arrays.toString(arr2));
        long l3 = System.currentTimeMillis();
        IO.println(l3-l2);
    }
}