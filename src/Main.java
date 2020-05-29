
import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class Main {
    public static void main(String[] args) {
        int[] array = {9, 3, 5, 6, 0, 4, 1, 2, 7, 8};
        System.out.println(Arrays.toString(array));
        bubbleSorti(array);
        System.out.println(Arrays.toString(array));
        int[] array2 = {8, 3, 5, 6, 0, 4, 1, 2, 7, 9};
        System.out.println(Arrays.toString(array2));
        mergeSort(array2,array2.length);
        System.out.println(Arrays.toString(array2));
        IntUnaryOperator mult2 = num -> num * 2;
        IntUnaryOperator add3 = num -> num + 3;

        IntUnaryOperator combinedOperator = add3.compose(mult2.andThen(add3)).andThen(mult2);
        int result = combinedOperator.applyAsInt(5);
        System.out.println(result);
    }

    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
        merge(a, l, r, mid, n - mid);
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
    public static void bubbleSorti(int[] array){
        int temp = 0;
        for (int i = array.length-1; i >=1 ; i--) {
            for (int j = 0; j <i ; j++) {
                if (array[j]> array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    
}

