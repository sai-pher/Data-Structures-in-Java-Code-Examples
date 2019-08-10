package SortingAndSearchingAlgorithms;

public class searching {

    public static boolean sequentialSearch(int[] alist, int item) {

        for (int a : alist) {
            if (a == item)
                return true;
        }

        return false;
    }


    public static boolean orderedSequentialSearch(int[] alist, int item) {

        for (int a : alist) {
            if (a == item)
                return true;
            else if (a > item)
                return false;
        }

        return false;
    }


    public static boolean binarySearch(int[] alist, int item) {


        int upper = alist.length - 1;
        int lower = 0;
        int i     = (upper + lower) / 2;

        while (lower < i) {
//            System.out.printf("i = %d l = %d u = %d%n", i, lower, upper);
            if (alist[i] == item | alist[lower] == item | alist[upper] == item)
                return true;
            else if (alist[i] < item) {
                lower = i;
            }
            else if (alist[i] > item) {
                upper = i;
            }
            i = (upper + lower) / 2;
        }

        return false;
    }

}
