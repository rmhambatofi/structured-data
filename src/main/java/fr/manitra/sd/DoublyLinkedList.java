package fr.manitra.sd;

/**
 * Created by manitra on 25/10/16.
 */
public class DoublyLinkedList<T> {
    private int size;
    private Node<T> header;
    private Node<T> tailer;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T first() {
        if (isEmpty()) {
            return null;
        }
        return header.getElement();
    }
}
