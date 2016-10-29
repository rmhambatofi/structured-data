package fr.manitra.sd;

/**
 * Created by manitra on 25/10/16.
 */
public class DoublyLinkedList<T> {
    private int size;
    private Node<T> header;
    private Node<T> tailer;

    public DoublyLinkedList() {
        this.size = 0;
        this.header = new Node<T>(null, null, null);
        this.tailer = new Node<T>(null, header, null);
    }

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
        return header.getNext().getElement();
    }

    public T last() {
        if (isEmpty()) {
            return null;
        }
        return tailer.getPrevious().getElement();
    }

    public void addFirst(T newElement) {
        addBetween(newElement, header, header.getNext());
    }

    public void addLast(T newElement) {
        addBetween(newElement, tailer.getPrevious(), tailer);
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        return remove(header.getNext());
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        return remove(tailer.getPrevious());
    }

    private void addBetween(T element, Node<T> predecessor, Node<T> successor) {
        Node<T> newNode = new Node<>(element, predecessor, successor);
        successor.setPrevious(newNode);
        predecessor.setNext(newNode);
        size++;
    }

    private T remove(Node<T> node) {
        Node<T> prev = node.getPrevious();
        Node<T> next = node.getNext();
        prev.setNext(next);
        next.setPrevious(prev);
        size--;
        return node.getElement();
    }

    private class Node<T> {
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

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Node{");
            sb.append("element=").append(element);
            sb.append(", previous=").append(previous);
            sb.append(", next=").append(next);
            sb.append('}');
            return sb.toString();
        }
    }
}
