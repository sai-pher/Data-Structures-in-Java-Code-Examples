package Lists;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class ArrayList<T> extends AbstractList<T> {

    int   length;
    int   size;
    Object[] list;

    // ================================================================

    public ArrayList() {
        this.length = DEFAULT_CAPACITY;
        this.size = 0;
        list = new Object[length];
    }

    public ArrayList(int length) {
        this.length = length;
        this.size = 0;
        list = new Object[this.length];
    }

    // ================================================================

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(T item) {
        return super.add(item);
    }

    @Override
    public void add(int index, T item) {
        if (shouldGrow()) {
            grow();
        }
        else {
            list[index] = item;
            size += 1;
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> items) {
        for (T item : items) {
            add(item);
        }
        return true;
    }

    @Override
    public T get(int index) {

        return (T) list[index];
    }

    @Override
    public T set(int index, T item) {
        // code here
        return null;
    }

    @Override
    public boolean remove(Object item) {
        // code here
        return false;
    }

    @Override
    public int indexOf(T item) {
        // code here
        return 0;
    }

    @Override
    public int lastIndexOf(T item) {
        // code here
        return 0;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        // code here
        return null;
    }

    // ================================================================

    private void grow() {

        int   temLength = length * 2;
        Object[] tempList  = new Object[temLength];

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
        if (o == null || getClass() != o.getClass()) return false;

        ArrayList<?> arrayList = (ArrayList<?>) o;

        if (length != arrayList.length) return false;
        if (size != arrayList.size) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(list, arrayList.list);
    }

    @Override
    public int hashCode() {
        return length;
    }
}
