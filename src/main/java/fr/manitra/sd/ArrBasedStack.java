package fr.manitra.sd;

/**
 * Created by manitra on 29/10/2016.
 */
public class ArrBasedStack<E> implements Stack<E> {

    private static final int DEFAULT_CAPACITY = 1000;
    private E[] data;
    private int top = -1;

    public ArrBasedStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrBasedStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public void push(E e) {
        if (size() == data.length)
            throw new IllegalStateException("Stack is full");
        data[++top] = e;
    }

    @Override
    public E top() {
        if (isEmpty())
            return null;
        return data[top];
    }

    @Override
    public E pop() {
        if (isEmpty())
            return null;
        E answer = data[top];
        data[top] = null;
        top--;
        return answer;
    }
}
