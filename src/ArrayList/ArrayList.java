package ArrayList;

import java.util.Arrays;
import java.util.Objects;

public class ArrayList {

    int   length = 10;
    int   size   = 0;
    int[] list;

    // ================================================================

    public ArrayList(int LENGTH) {
        this.length = LENGTH;
        list = new int[LENGTH];
    }

    public ArrayList(int[] list) {
        this.list = list;
        length = list.length;
    }

    // ================================================================

    public ArrayList() {
        list = new int[length];
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int[] getList() {
        return list;
    }

    public void setList(int[] list) {
        this.list = list;
    }

    // ================================================================

    public void insert(int num) {

        if (shouldGrow()) {
            grow();
        }
        else {
            list[size] = num;
            size++;
        }
    }

    public int get(int index) {

        return list[index];
    }

    public void delete(int index) {

        list[index] = Integer.parseInt(null);
    }

    public int size() {
        return size;
    }

    // ================================================================

    private void grow() {

        int   temLength = length * 2;
        int[] tempList  = new int[temLength];

        for (int i = 0; i < length; i++) {
            tempList[i] = list[i];
        }

        list = tempList;

    }

    private boolean shouldGrow() {

        return size == length - 1;
    }


    // ================================================================


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayList)) return false;
        ArrayList arrayList = (ArrayList) o;
        return length == arrayList.length &&
               Arrays.equals(list, arrayList.list);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(length);
        result = 31 * result + Arrays.hashCode(list);
        return result;
    }
}
