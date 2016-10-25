package fr.manitra.sd.singly;

/**
 * Created by manitra on 26/10/2016.
 */
public class SinglyLinkedList<T> {
    private int size = 0;
    private SinglyNode<T> head;
    private SinglyNode<T> tail;

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
        return head.getElement();
    }

    public T last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(T element) {
        head = new SinglyNode<>(element, head);
        if (isEmpty()) {
            tail = head;
        }
        size++;
    }

    public void addLast(T element) {
        SinglyNode<T> newNode = new SinglyNode<>(element, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T answer = head.getElement();
        head = head.getNext();
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return answer;
    }
}
