package fr.manitra.sd;

/**
 * Created by manitra on 30/10/2016.
 */
public interface List<E> {

    int size();

    boolean isEmpty();

    E get(int i) throws IndexOutOfBoundsException;

    /**
     * Replaces the element at index i with e, and returns the replaced element.
     * @param i index of the element to be replaced
     * @param e new element
     * @return the element that has been replaced
     * @throws IndexOutOfBoundsException
     */
    E set(int i, E e) throws IndexOutOfBoundsException;

    void add (int i, E e) throws IndexOutOfBoundsException;

    E remove(int i) throws IndexOutOfBoundsException;
}
