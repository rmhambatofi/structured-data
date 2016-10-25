package fr.manitra.sd.singly;

/**
 * Created by manitra on 26/10/2016.
 */
public class SinglyNode<T> {
    private T element;
    private SinglyNode<T> next;

    public SinglyNode(T element, SinglyNode<T> next) {
        this.element = element;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public SinglyNode<T> getNext() {
        return next;
    }

    public void setNext(SinglyNode<T> next) {
        this.next = next;
    }
}
