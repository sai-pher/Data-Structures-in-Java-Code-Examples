package Lists;

import java.util.Collection;

public interface List<T> {

/** Positional access */

    /**
     * Appends the specified element to the end of this list (optional operation).
     * @param item
     * @return
     */
    boolean add(T item);

    /**
     * Appends all of the elements in the specified collection to the end of this list,
     * in the order that they are returned by the specified collection's iterator (optional operation).
     * @param items
     * @return
     */
    boolean addAll(Collection<? extends T> items);

    /**
     * Returns the element at the specified position in this list.
     * @param index
     * @return
     */
    T get(int index);

    /**
     * Replaces the element at the specified position in this list with the specified element (optional operation).
     * @param index
     * @param item
     * @return
     */
    T set(int index, T item);

    /**
     * Removes the first occurrence of the specified element from this list, if it is present (optional operation).
     * @param item
     * @return
     */
    boolean remove(Object item);


/** Search */

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     * @param item
     * @return
     */
    int indexOf(T item);

    /**
     * Returns the index of the last occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     * @param item
     * @return
     */
    int lastIndexOf(T item);

/** Range-view */

    /**
     * @param fromIndex
     * @param toIndex
     * @return
     */
    List<T> subList(int fromIndex, int toIndex);

}
