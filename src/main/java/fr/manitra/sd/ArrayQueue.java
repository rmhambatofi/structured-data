package fr.manitra.sd;

/**
 * Created by manitra on 30/10/2016.
 */
public class ArrayQueue<E> implements Queue<E> {

    private static final int DEFAULT_CAPACITY = 1000;
    private E[] data;
    private int front = 0;
    private int nbElement = 0;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return data.length;
    }

    @Override
    public boolean isEmpty() {
        return data.length == 0;
    }

    @Override
    public void enqueue(E e) {
        if (nbElement == data.length)
            throw new IllegalStateException("Queue is full");
        int avail = (front + nbElement) % data.length;
        data[avail] = e;
    }

    @Override
    public E first() {
        if (isEmpty()) return null;
        return data[front];
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        E answer = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        return answer;
    }
}
