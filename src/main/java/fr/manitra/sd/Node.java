package fr.manitra.sd;

/**
 * Created by manitra on 25/10/16.
 */
public class Node<T> {
    private T element;
    private Node<T> previous;
    private Node<T> next;

    public Node(T element, Node<T> previous, Node<T> next) {
        this.element = element;
        this.previous = previous;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
