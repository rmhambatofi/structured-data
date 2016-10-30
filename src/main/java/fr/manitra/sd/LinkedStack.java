package fr.manitra.sd;

import fr.manitra.sd.singly.SinglyLinkedList;

/**
 * Created by manitra on 30/10/2016.
 */
public class LinkedStack<E> implements Stack<E> {

    private SinglyLinkedList<E> linkedList;

    public LinkedStack() {
        this.linkedList = new SinglyLinkedList<>();
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E top() {
        return linkedList.first();
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }
}
