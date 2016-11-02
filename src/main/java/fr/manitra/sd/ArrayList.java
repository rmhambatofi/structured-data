package fr.manitra.sd;

/**
 * Created by manitra on 30/10/2016.
 */
public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 16;
    private E[] data;
    private int size = 0;

    public ArrayList() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        if (isEmpty()) {
            return null;
        }
        checkIndex(i, size);
        return data[i];
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size + 1);
        if (size == data.length)
            throw new IndexOutOfBoundsException("Array is full");
        for (int j = size - 1; j >= i; j--) {
            data[j + 1] = data[j];
        }
        data[i] = e;
        size++;
    }

    @Override
    public void add(E e) {
        if (size == data.length)
            throw new IndexOutOfBoundsException("Array is full");
        data[size] = e;
        size++;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for (int j = size - 1; j > i; j--) {
            data[j - 1] = data[j];
        }
        size--;
        return temp;
    }

    private void checkIndex(int index, int n) {
        if (index < 0 || index >= n) {
            throw new IndexOutOfBoundsException("Illegal index: " + index);
        }
    }
}
