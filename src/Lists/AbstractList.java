package Lists;

import java.util.Collection;

public abstract class AbstractList<T> implements List<T> {

    protected static final int DEFAULT_CAPACITY = 10;

    public abstract int size();

    public abstract boolean isEmpty();

    @Override
    public boolean add(T item){
        add(size(), item);
        return true;
    }

    public abstract void add(int index, T item);

    @Override
    public abstract boolean addAll(Collection<? extends T> items);

    @Override
    public abstract T get(int index);

    @Override
    public abstract T set(int index, T item);

    @Override
    public abstract boolean remove(Object item);

    @Override
    public abstract int indexOf(T item);

    @Override
    public abstract int lastIndexOf(T item);

    @Override
    public abstract List<T> subList(int fromIndex, int toIndex);

}
