package fr.manitra.sd;

/**
 * Created by manitra on 30/10/2016.
 */
public interface Queue<E> {

    /**
     * Returns the number of element in the queue
     * @return
     */
    int size();

    /**
     * Test whether queue is empty
     * @return
     */
    boolean isEmpty();

    /**
     * Inserts an element at the rear of the queue
     * @param e
     */
    void enqueue(E e);

    /**
     * Returns, but not remove the first element of the queue
     * @return the first element, null if queue is empty
     */
    E first();

    /**
     * Removes and return the first element of the queue
     * @return the first element, null if empty
     */
    E dequeue();
}
