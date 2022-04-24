package Algorithms;

public class Sorting {

    public static int[] bubbleSort(int[] alist) {

        for (int i = 0; i < alist.length; i++) {
            for (int j = 1; j < alist.length; j++) {
                if (alist[j - 1] > alist[j]) {

                    alist = swap(alist, j, j - 1);
                }
            }
        }

        return alist;
    }

    public static int[] selectionSort(int[] alist) {

        int min, m_i = 0;

        for (int i = 0; i < alist.length; i++) {

            for (int j = i; i < alist.length; i++) {
                if (alist[j] < alist[i])
                    m_i = j;
                alist = swap(alist, m_i, i);
            }
        }

        return alist;
    }

    private static int[] swap(int[] alist, int j, int i) {
        int temp = alist[j];
        alist[j] = alist[i];
        alist[i] = temp;
        return alist;
    }
}
