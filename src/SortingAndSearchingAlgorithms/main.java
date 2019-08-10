package SortingAndSearchingAlgorithms;


import java.util.Arrays;

public class main {


    public static void main(String[] args) {
        var lst = new int[]{1, 5, 3, 2, 8, 6, 4, 9, 7, 0};

        for (int i = 0; i < 15; i++) {

            var b = searching.binarySearch(lst, i);
            System.out.println(b);
        }

        System.out.println(Arrays.toString(Sorting.selectionSort(lst)));

    }


}
